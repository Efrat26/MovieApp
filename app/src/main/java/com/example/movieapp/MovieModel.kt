package com.example.movieapp

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    val name: String,
    @DrawableRes val imageRes: Int,
    val overview: String?,
    val releaseDate: String?,
    val trailerLink: String?,
    @DrawableRes  val backImageRes: Int
) : Parcelable
