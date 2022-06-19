package com.example.album.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.album.feature.databinding.AlbumFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

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
        viewModel.getAlbumList(0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner) {
            binding.message.text = it
        }
    }

    companion object {
        fun newInstance() = AlbumListFragment()
    }

}