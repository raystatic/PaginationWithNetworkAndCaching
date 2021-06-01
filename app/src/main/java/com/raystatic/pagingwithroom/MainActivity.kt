package com.raystatic.pagingwithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.raystatic.pagingwithroom.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewmodel by viewModels<ArticleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsListAdapter = NewsListAdapter()
        binding.rvNewsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter=  newsListAdapter
        }
        lifecycleScope.launchWhenStarted {
            viewmodel.dataFlow.collectLatest {
                newsListAdapter.submitData(it)
            }
        }

    }
}