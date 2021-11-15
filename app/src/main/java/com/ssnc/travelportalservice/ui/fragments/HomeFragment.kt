package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.MainActivity
import com.ssnc.travelportalservice.ui.adapters.HotelListAdapter
import com.ssnc.travelportalservice.util.AlertDialog
import com.ssnc.travelportalservice.util.ItemDialog
import com.ssnc.travelportalservice.util.Resource
import com.ssnc.travelportalservice.viewmodel.HotelViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    private val TAG = "HomeFragment"

    private lateinit var viewModel: HotelViewModel
    private lateinit var hotelAdapter: HotelListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment", "Home Fragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).hotelViewModel
        setUpRecyclerView()

        hotelAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("hotel", it)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_hotelDetailFragment,
                bundle
            )
        }

        viewModel.hotelByName.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    showDataView()
                    response.data?.let { hotelResponse ->
                        hotelAdapter.differ.submitList(hotelResponse)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Log.d(TAG, "Error -----> $it")
//                        showError(it)
                        showErrorView()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Timeout -> {
                    response.message?.let {
                        showError(it)
                    }
                }
            }
        })

        txt_try_again.setOnClickListener(this)
    }

    private fun showDataView() {
//        layout_search.visibility = View.VISIBLE
        recycler_view_home.visibility = View.VISIBLE
        error_view.visibility = View.INVISIBLE
    }

    private fun showErrorView() {
        error_view.visibility = View.VISIBLE
//        layout_search.visibility = View.INVISIBLE
        recycler_view_home.visibility = View.INVISIBLE
    }

    private fun showError(message: String) {
        val item = ItemDialog(message = message,
        positiveText = "Ok",
        positiveListener = { dialogInterface, _ ->
            dialogInterface.dismiss()
        })

        parentFragmentManager.let {
            AlertDialog.removeFragment(it, AlertDialog.TAG)
            AlertDialog.newInstance(item).show(it, AlertDialog.TAG)
        }
    }

    private fun hideProgressBar() {
        progress.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progress.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView() {
        hotelAdapter = HotelListAdapter()
        recycler_view_home.apply {
            adapter = hotelAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onClick(p0: View?) {
        if (p0 == null) return
        when (p0.id) {
            R.id.txt_try_again -> {
                error_view.visibility = View.INVISIBLE
                Log.d(TAG, "Try again")
                showProgressBar()
                viewModel.getHotel("Himal")
//                observeHotelData()
            }
        }
    }
}