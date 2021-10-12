package com.example.movieapp.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.DetailMovieResponse
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailsInterface.View {

    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter = DetailsPresenter(this)


    }

    override fun onStart() {
        super.onStart()
        val intent = intent
        val name = intent.getStringExtra("movie_id")
        presenter.getDetailsMovie(name!!)

    }

    override fun initActivity() {
        supportActionBar?.hide()
    }

    override fun onResultDetailsMovie(response: DetailMovieResponse) {
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${response.backdrop_path}")
            .into(details_image)
        details_language.text = response.original_language
        details_rate.text = response.vote_average
        details_view.text = response.vote_count
        details_overview.text = response.overview
    }
}