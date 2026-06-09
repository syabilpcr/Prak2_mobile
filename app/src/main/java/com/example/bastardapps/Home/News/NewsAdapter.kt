package com.example.bastardapps.Home.News

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bastardapps.Data.Model.NewsArticle
import com.example.bastardapps.R
import com.example.bastardapps.databinding.ItemNewsBinding

class NewsAdapter(private val articles: List<NewsArticle>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.tvNewsTitle.text = article.title ?: "Tanpa judul"
        holder.binding.tvNewsDescription.text = article.description ?: ""
        holder.binding.tvNewsSource.text = article.source?.name ?: ""
        Glide.with(holder.itemView.context)
            .load(article.urlToImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.binding.ivNewsThumbnail)
    }
}