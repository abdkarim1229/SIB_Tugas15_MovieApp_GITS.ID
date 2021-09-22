package com.example.movieapp.activity.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.model.ResultsItem

class MovieAdapterScroll(private var listScroll: ArrayList<ResultsItem>) :
    RecyclerView.Adapter<MovieAdapterScroll.myViewHolder>() {
    class myViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var image: ImageView = itemView.findViewById(R.id.image_scroll)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scroll, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = listScroll[position]
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            .apply(RequestOptions().override(320, 320)).into(holder.image)
    }

    override fun getItemCount() = listScroll.size

    fun setData(data: List<ResultsItem>) {
        listScroll.clear()
        listScroll.addAll(data)
        notifyDataSetChanged()
    }
}
