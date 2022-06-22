package com.example.album.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.album.feature.databinding.AlbumFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AlbumListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: AlbumFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AlbumFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("on cerate")
        viewModel.getAlbumList(1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shimmerView.startShimmer()

        viewModel.text.observe(viewLifecycleOwner) {
            binding.shimmerView.apply {
                stopShimmer()
                visibility = View.GONE
            }
            binding.message.apply {
                text = it
                visibility = View.VISIBLE
            }
        }
    }

}