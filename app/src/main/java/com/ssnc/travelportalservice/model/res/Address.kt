package com.ssnc.travelportalservice.model.res

import java.io.Serializable

data class Address(
    val addressId: String,
    val addressName: String,
    val addressNameEdited: String,
    val image: String
): Serializable