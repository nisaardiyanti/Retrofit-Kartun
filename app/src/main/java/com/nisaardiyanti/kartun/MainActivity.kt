package com.nisaardiyanti.kartun

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nisaardiyanti.kartun.adapter.CharacterAdapter
import com.nisaardiyanti.kartun.databinding.ActivityMainBinding
import com.nisaardiyanti.kartun.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var characterAdapter: CharacterAdapter
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadData()

    }


    private fun setupRecyclerView() {
        //nomer dua bagian recycleview
        //function recyclerView digunakan untuk RecyclerView memudahkan untuk
        // menampilkan kumpulan data besar secara efisien.

        characterAdapter = CharacterAdapter()

        binding.recyclerView.apply {
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }

    }

    private fun loadData() {
//function untuk Bangun objek Retrofit
        lifecycleScope.launch {
            viewModel.listData.collect {
//LifecycleScope ditentukan untuk setiap objek Lifecycle. Semua coroutine yang
// diluncurkan dalam cakupan ini dibatalkan saat Lifecycle dihancurkan.
// Anda dapat mengakses CoroutineScope dari Lifecycle baik melalui lifecycle.
                Log.d("aaa", "load: $it")
                characterAdapter.submitData(it)
            }

        }
    }
}
