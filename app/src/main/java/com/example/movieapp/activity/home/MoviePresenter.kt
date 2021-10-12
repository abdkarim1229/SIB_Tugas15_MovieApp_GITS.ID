package com.example.movieapp.activity.home

import android.widget.Toast
import com.example.movieapp.model.MovieResponse
import com.example.movieapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(var view: MovieInterface.View) : MovieInterface.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }

    override fun getMovie() {
        ApiService.endpoint.getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val response: MovieResponse? = response.body()
                    view.onResultMovie(response!!)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }

    override fun getMovieScroll() {
        ApiService.endpoint.getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val responseScroll: MovieResponse? = response.body()
                    view.onResultMovieScroll(responseScroll!!)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }

}