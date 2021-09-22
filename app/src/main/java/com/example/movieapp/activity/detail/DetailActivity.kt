package com.example.movieapp.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.activity.home.MovieAdapter
import com.example.movieapp.model.DetailMovieResponse
import com.example.movieapp.model.ResultsItemDetail
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    val adapter = MovieAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("image")}").apply(
                RequestOptions().override(320, 320)
            ).into(details_image)

        details_language.text = intent.getStringExtra("bahasa")
        details_rate.text = intent.getDoubleExtra("rate", 0.0).toString()
        details_view.text = intent.getIntExtra("review", 0).toString()
        details_overview.text = intent.getStringExtra("overview")
    }

}
