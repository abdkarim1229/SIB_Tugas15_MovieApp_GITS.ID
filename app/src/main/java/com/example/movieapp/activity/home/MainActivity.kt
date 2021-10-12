package com.example.movieapp.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.model.MovieResponse
import com.example.movieapp.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieInterface.View {

    lateinit var presenter: MoviePresenter
    val movieAdapterScroll = MovieAdapterScroll(arrayListOf())
    val movieAdapter = MovieAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MoviePresenter(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.getMovie()
        presenter.getMovieScroll()
    }

    override fun initListener() {
        rv_scroll.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_scroll.adapter = movieAdapterScroll

        rv_movie.layoutManager = LinearLayoutManager(this)
        rv_movie.adapter = movieAdapter
    }

    override fun initActivity() {
        supportActionBar?.hide()
    }

    override fun onResultMovie(response: MovieResponse) {
        val result = response.results
        movieAdapter.setData(result as List<ResultsItem>)
    }

    override fun onResultMovieScroll(response: MovieResponse) {
        val resultScroll = response.results
        movieAdapterScroll.setData(resultScroll as List<ResultsItem>)
    }
}