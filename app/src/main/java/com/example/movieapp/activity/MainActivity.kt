package com.example.movieapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.model.MovieResponse
import com.example.movieapp.model.ResultsItem
import com.example.movieapp.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val movieAdapter = MovieAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_movie.layoutManager = LinearLayoutManager(this)
        rv_movie.adapter = movieAdapter
        getDataMovie()
    }

    private fun getDataMovie() {
        ApiService.endpoint.getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { tampilMovie(it) }
                    val result = response.body()!!.results
                    for (item in result!!) {
                        detailMovie(item!!.id)

                    }
                } else {
                    Toast.makeText(this@MainActivity, "Response Gagal", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal GET Data ${t}", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun detailMovie(id: Int?) {
        ApiService
    }

    private fun tampilMovie(data: MovieResponse) {
        val result = data.results
        movieAdapter.setData(result as List<ResultsItem>)
    }
}