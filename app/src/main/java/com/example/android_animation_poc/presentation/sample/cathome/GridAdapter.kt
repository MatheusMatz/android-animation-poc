package com.example.android_animation_poc.presentation.sample.cathome

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android_animation_poc.databinding.ItemPrincipalBinding
import com.example.android_animation_poc.databinding.ItemSecondaryBinding
import com.example.android_animation_poc.presentation.sample.dto.Curiosity
import android.util.Pair as UtilPair

class GridAdapter(private val clickListener: (() -> Unit)) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        const val TYPE_PRINCIPAL = 0
        const val TYPE_SECONDARY = 1
    }

    private val curiosities: MutableList<Curiosity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_PRINCIPAL -> {
                val inflate =
                    ItemPrincipalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PrincipalViewHolder(inflate)
            }
            TYPE_SECONDARY -> {
                val inflate =
                    ItemSecondaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SecondaryViewHolder(inflate)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = curiosities.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PrincipalViewHolder -> holder.bind(curiosities[position], clickListener)
            is SecondaryViewHolder -> holder.bind(curiosities[position], clickListener)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (curiosities[position]?.wasPrincipal) {
            TYPE_PRINCIPAL
        } else {
            TYPE_SECONDARY
        }
    }

    fun setItems(list: List<Curiosity>) {
        curiosities.clear()
        curiosities.addAll(list)
        notifyDataSetChanged()
    }
}

class PrincipalViewHolder(private val viewBinding: ItemPrincipalBinding) :
    BaseViewHolder<Curiosity>(viewBinding.root) {

    override fun bind(curiosity: Curiosity, clickListener: (() -> Unit)) {

        val intent = Intent(
            viewBinding.imagePrincipal.context,
            ItemInfoActivity::class.java
        ).putExtra("INFO", curiosity)

        viewBinding.imagePrincipal.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(
                it.context as Activity,
                UtilPair.create(viewBinding.imagePrincipal, "image"),
                UtilPair.create(viewBinding.curiSPrincipal, "title")
            )

            it.context.startActivity(intent, options.toBundle())
            clickListener()
        }
        viewBinding.curiSPrincipal.text = curiosity.title
        viewBinding.imagePrincipal.load(curiosity.image) {

        }
    }
}

class SecondaryViewHolder(private val viewBinding: ItemSecondaryBinding) :
    BaseViewHolder<Curiosity>(viewBinding.root) {

    override fun bind(curiosity: Curiosity, clickListener: (() -> Unit)) {
        viewBinding.curiSecun.text = curiosity.title
        viewBinding.imageSecund.load(curiosity.image) {
            crossfade(true)
        }

        val intent = Intent(
            viewBinding.imageSecund.context,
            ItemInfoActivity::class.java
        ).putExtra("INFO", curiosity)

        viewBinding.imageSecund.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(
                it.context as Activity,
                UtilPair.create(viewBinding.imageSecund, "image"),
                UtilPair.create(viewBinding.curiSecun, "title")
            )

            it.context.startActivity(intent, options.toBundle())
            clickListener()
        }
    }
}