package com.example.myrecipeapp
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(val title: String,
                  val cooking_time: String,
                  val details: String,
                  val imageUrl: String): Parcelable
