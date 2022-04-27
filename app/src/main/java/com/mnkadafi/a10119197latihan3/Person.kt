package com.mnkadafi.a10119197latihan3

//<!--27 April 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val age: Int?
): Parcelable