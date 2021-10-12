package com.example.movieapp.activity.detail

import com.example.movieapp.model.DetailMovieResponse
import com.example.movieapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPresenter(var view: DetailsInterface.View) : DetailsInterface.Presenter {

    init {
        view.initActivity()
    }

    override fun getDetailsMovie(id: String) {
        ApiService.endpoint.getDetail(id).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                if (response.isSuccessful) {
                    val details: DetailMovieResponse? = response.body()
                    view.onResultDetailsMovie(details!!)
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
            }

        })
    }

}