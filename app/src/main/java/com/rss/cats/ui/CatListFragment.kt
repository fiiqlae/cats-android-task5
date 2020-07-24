package com.rss.cats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rss.cats.R
import com.rss.cats.databinding.FragmentCatListBinding
import com.rss.cats.models.Cat
import com.rss.cats.models.CatViewModel
import com.rss.cats.models.SharedViewModel

class CatListFragment : Fragment(), CatListener {

    private var _binding: FragmentCatListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val catViewModel: CatViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CatAdapter(this)
        configureRecycler(adapter)

        catViewModel.allCats.observe(viewLifecycleOwner, Observer { cats ->
            cats?.let { adapter.setDataSet(it) }
        })
    }

    private fun configureRecycler(adapter: CatAdapter) {
        val recycler = binding.catRecycler
        recycler.layoutManager =
            StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
        recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDataSetExhausted() {
        catViewModel.loadNextPage()
    }

    override fun onPreview(cat: Cat) {
        val previewFragment = PreviewFragment()
        sharedViewModel.selectCat(cat)
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.anim_flip_right_in,
                R.animator.anim_flip_right_out,
                R.animator.anim_flip_left_in,
                R.animator.anim_flip_left_out
            )
            .replace(R.id.placeholder, previewFragment).addToBackStack("preview").commit()
    }

    companion object {
        private const val spanCount = 3
    }
}