package com.example.movieapp.network

import com.example.movieapp.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiEndPoint {
    @GET("movie/popular?api_key=8152b136a5dad36d2ca7844f884577ba&language=en&page=1")
    fun getMovie(): Call<MovieResponse>
}