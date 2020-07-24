package com.rss.cats.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.rss.cats.data.ImageLoader
import com.rss.cats.databinding.CatListElementBinding
import com.rss.cats.di.App
import com.rss.cats.models.Cat
import javax.inject.Inject

class CatAdapter(
    private val listener: CatListener
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    private var catDataSet = emptyList<Cat>()
    private val set = ConstraintSet()

    @Inject lateinit var imageLoader: ImageLoader

    init {
        App.daggerComponent.inject(this)
    }

    inner class CatViewHolder(val binding: CatListElementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var cat: Cat? = null
        fun bindCat(cat: Cat) {
            this.cat = cat
            imageLoader.loadImage(binding.catImage, cat.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatAdapter.CatViewHolder {
        return CatViewHolder(
            CatListElementBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatAdapter.CatViewHolder, position: Int) {
        holder.bindCat(catDataSet[position])

        setupRatio(holder.binding, requireNotNull(holder.cat))

        holder.itemView.setOnClickListener { listener.onPreview(catDataSet[position]) }
        if (position + 1 == catDataSet.size) listener.onDataSetExhausted()
    }

    private fun setupRatio(binding: CatListElementBinding, cat: Cat) {
        val ratio = String.format("%d:%d", cat.width, cat.height)
        set.clone(binding.frame)
        set.setDimensionRatio(binding.catImage.id, ratio)
        set.applyTo(binding.frame)
    }

    override fun getItemCount(): Int {
        return catDataSet.size
    }

    internal fun setDataSet(cats: List<Cat>) {
        this.catDataSet = cats
        notifyDataSetChanged()
    }
}