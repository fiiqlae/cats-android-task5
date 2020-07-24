package com.rss.cats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.rss.cats.databinding.FragmentPreviewBinding
import com.rss.cats.models.SharedViewModel

class PreviewFragment : Fragment() {
    private var _binding: FragmentPreviewBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedCat.observe(
            viewLifecycleOwner,
            Observer { viewModel.imageLoader.loadImage(binding.imagePreview, it.url) })

        binding.saveBtn.setOnClickListener {
            viewModel.saveCat(binding.imagePreview)
            Toast.makeText(context, "File saved", Toast.LENGTH_SHORT).show()
        }
    }
}