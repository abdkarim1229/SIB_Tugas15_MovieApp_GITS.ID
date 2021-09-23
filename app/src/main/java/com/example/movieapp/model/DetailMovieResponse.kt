package com.example.movieapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DetailMovieResponse(
    @SerializedName("original_language") val original_language: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("vote_average") val vote_average: String,
    @SerializedName("vote_count") val vote_count: String,
    @SerializedName("backdrop_path") val backdrop_path: String
) {

}