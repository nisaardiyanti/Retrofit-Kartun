package com.nisaardiyanti.kartun.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.nisaardiyanti.kartun.adapter.CharacterAdapter.ImageViewHolder
import com.nisaardiyanti.kartun.databinding.CharacterLayoutBinding
import com.nisaardiyanti.kartun.model.RickMorty

class CharacterAdapter : PagingDataAdapter<RickMorty,
//kelas adapter
        ImageViewHolder>(diffCallback) {
//no tiga class adapter

    inner class ImageViewHolder(
        val binding: CharacterLayoutBinding
            //validasi binding menggunakan characterlayoutbinding
    ) :
        ViewHolder(binding.root)
//viewholder menggunakan binding.root
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
                //mengembalikan imageviewholder
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
          //function on BindingViewHolder  
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                tvDescription.text = "${currChar?.name}"

                val imageLink = currChar?.image
                    //validasi untuk gambar
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }

    }


}
