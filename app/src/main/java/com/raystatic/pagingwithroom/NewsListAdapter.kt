package com.raystatic.pagingwithroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.raystatic.pagingwithroom.databinding.ItemNewsListBinding
import com.raystatic.pagingwithroom.response.Article

class NewsListAdapter: PagingDataAdapter<Article, NewsListAdapter.NewsListViewHolder>(NEWS_COMPARATOR) {

    inner class NewsListViewHolder(private val binding: ItemNewsListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:Article?, position: Int){
            binding.apply {
                tvTitle.text = item?.title
                tvTime.text= "Item number: ${position+1}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val binding = ItemNewsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }


    companion object{
        private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<Article>(){
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: Article,
                newItem: Article
            ) = oldItem == newItem
        }
    }
}