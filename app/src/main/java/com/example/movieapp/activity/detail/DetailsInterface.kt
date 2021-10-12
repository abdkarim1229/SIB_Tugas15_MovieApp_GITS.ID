package com.example.movieapp.activity.detail

import com.example.movieapp.model.DetailMovieResponse


interface DetailsInterface {
    interface Presenter {
        fun getDetailsMovie(id: String)
    }

    interface View {
        fun initActivity()
        fun onResultDetailsMovie(response: DetailMovieResponse)
    }
}
