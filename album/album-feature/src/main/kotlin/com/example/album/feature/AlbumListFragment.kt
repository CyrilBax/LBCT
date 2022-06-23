package com.example.album.feature

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.album.feature.adapters.AlbumListAdapter
import com.example.album.feature.databinding.AlbumFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AlbumListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: AlbumFragmentBinding
    private lateinit var albumAdapter: AlbumListAdapter
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AlbumFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAlbumList(page)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("HELLO WORLD !")
        albumAdapter = AlbumListAdapter()
        binding.shimmerView.shimmer.startShimmer()
        binding.albumListRecyclerView.apply {
            (layoutManager as GridLayoutManager).apply {
                orientation = GridLayoutManager.VERTICAL
                spanCount = 2
            }
            adapter = albumAdapter
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!binding.albumListRecyclerView.canScrollVertically(View.SCROLL_AXIS_VERTICAL)) {
                        page++
                        viewModel.getAlbumList(page)
                    }
                }
            })
        }

        viewModel.albumList.observe(viewLifecycleOwner) {
            binding.shimmerView.shimmer.apply {
                stopShimmer()
                visibility = View.GONE
            }
            albumAdapter.setAlbumList(it)
        }
    }

}