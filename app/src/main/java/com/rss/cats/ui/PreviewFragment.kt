package com.rss.cats.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.rss.cats.R
import com.rss.cats.databinding.FragmentPreviewBinding
import com.rss.cats.models.Cat


class PreviewFragment(private val cat: Cat) : Fragment() {
    private var _binding: FragmentPreviewBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view.context)
            .load(cat.url)
            .placeholder(R.mipmap.bg)
            .override(cat.width, cat.height)
            .into(binding.imagePreview)

        binding.saveBtn.setOnClickListener {
            saveToGallery((binding.imagePreview.drawable as BitmapDrawable).bitmap)
        }

    }

    private fun saveToGallery(bitmap: Bitmap) {
        MediaStore.Images.Media.insertImage(requireActivity().contentResolver,
            bitmap,
            "${System.currentTimeMillis()}",
            "")
        Toast.makeText(context, "file saved", Toast.LENGTH_SHORT).show()
    }
}