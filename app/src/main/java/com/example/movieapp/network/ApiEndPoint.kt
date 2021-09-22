package com.example.movieapp.network

import com.example.movieapp.model.DetailMovieResponse
import com.example.movieapp.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiEndPoint {
    @GET("movie/popular?api_key=bc79104b108ca2dee02339203c934fd1&language=en-US&page=1")
    fun getMovie(): Call<MovieResponse>

}