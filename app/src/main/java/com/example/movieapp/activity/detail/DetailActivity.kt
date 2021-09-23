package com.example.movieapp.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.activity.home.MovieAdapter
import com.example.movieapp.model.DetailMovieResponse
import com.example.movieapp.network.ApiService
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        val intent = intent
        val name = intent.getIntExtra("movie_id", 0)
        getDetail(name)
    }

    private fun getDetail(id: Int) {
        ApiService.endpoint.getDetail(id).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                if (response.isSuccessful) {
                    val detail: DetailMovieResponse = response.body()!!
                    resultDetail(detail)
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun resultDetail(detail: DetailMovieResponse) {
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${detail.backdrop_path}")
            .into(details_image)
        details_language.text = detail.original_language
        details_rate.text = detail.vote_average
        details_view.text = detail.vote_count
        details_overview.text = detail.overview
    }

}