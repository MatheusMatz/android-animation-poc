package com.example.android_animation_poc.presentation.sample.cathome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android_animation_poc.databinding.ItemPrincipalBinding
import com.example.android_animation_poc.databinding.ItemSecondaryBinding
import com.example.android_animation_poc.presentation.sample.dto.Curiosity

class GridAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

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
            is PrincipalViewHolder -> holder.bind(curiosities[position])
            is SecondaryViewHolder -> holder.bind(curiosities[position])
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

    override fun bind(curiosity: Curiosity) {
        viewBinding.curiSPrincipal.text = curiosity.title
        viewBinding.imagePrincipal.load(curiosity.image) {
            crossfade(true)
        }
    }
}

class SecondaryViewHolder(private val viewBinding: ItemSecondaryBinding) :
    BaseViewHolder<Curiosity>(viewBinding.root) {

    override fun bind(curiosity: Curiosity) {
        viewBinding.curiSecun.text = curiosity.title
        viewBinding.imageSecund.load(curiosity.image) {
            crossfade(true)
        }
    }
}