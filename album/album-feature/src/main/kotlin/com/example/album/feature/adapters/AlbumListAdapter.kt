package com.example.album.feature.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.album.feature.databinding.AlbumItemBinding
import com.example.album.feature.models.AlbumModelUi
import com.example.album.feature.viewholders.AlbumListViewHolder

class AlbumListAdapter : RecyclerView.Adapter<AlbumListViewHolder>() {

    private var albumList: MutableList<AlbumModelUi> = mutableListOf()

    fun setAlbumList(albumList: List<AlbumModelUi>) {
        this.albumList.addAll(albumList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumListViewHolder(
        AlbumItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: AlbumListViewHolder, position: Int) {
        holder.bind(
            pictureUrl = albumList[position].thumbnailUrl,
            title = albumList[position].title
        )
    }

    override fun getItemCount() = albumList.size
}