package com.example.movieapp.activity.home

import com.example.movieapp.model.MovieResponse

interface MovieInterface {
    interface Presenter {
        fun getMovie()
        fun getMovieScroll()
    }

    interface View {
        fun initListener()
        fun initActivity()
        fun onResultMovie(response: MovieResponse)
        fun onResultMovieScroll(response: MovieResponse)
    }
}