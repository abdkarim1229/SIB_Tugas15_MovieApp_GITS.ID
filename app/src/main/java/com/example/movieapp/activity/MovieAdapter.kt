package com.example.movieapp.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.model.ResultsItem

class MovieAdapter(private val listMovie: ArrayList<ResultsItem>) :
    RecyclerView.Adapter<MovieAdapter.myViewHolder>() {

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val judul: TextView = itemView.findViewById(R.id.item_judul)
        val release: TextView = itemView.findViewById(R.id.item_release)
        val bahasa: TextView = itemView.findViewById(R.id.item_language)
        val rate: TextView = itemView.findViewById(R.id.item_rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = listMovie[position]
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            .apply(RequestOptions().override(320, 320)).into(holder.image)
        holder.judul.text = data.title
        holder.release.text = "Release : ${data.releaseDate}"
        holder.bahasa.text = "Languange : ${data.originalLanguage}"
        holder.rate.text = "Rating :${data.voteAverage.toString()}"
    }

    override fun getItemCount() = listMovie.size

    fun setData(data: List<ResultsItem>) {
        listMovie.clear()
        listMovie.addAll(data)
        notifyDataSetChanged()
    }
}
