package com.example.album.feature.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.album.feature.databinding.AlbumItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class AlbumListViewHolder(
    private val binding: AlbumItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pictureUrl: String, title: String) {
        binding.progressIndicator.show()
        binding.title.text = title
        Picasso.get()
            .load(pictureUrl)
            .into(binding.picture, object : Callback {
                override fun onSuccess() {
                    binding.progressIndicator.hide()
                }

                override fun onError(e: Exception?) {
                    binding.progressIndicator.hide()
                }

            })
        /*Glide
            .with(binding.root.context)
            .load(pictureUrl)
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressIndicator.visibility = View.GONE
                    binding.pictureError.visibility = View.VISIBLE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressIndicator.visibility = View.GONE
                    return false
                }

            })
            .into(binding.picture)*/

    }
}