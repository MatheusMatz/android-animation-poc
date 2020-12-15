package com.example.android_animation_poc.presentation.visibility

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.android_animation_poc.R
import com.example.android_animation_poc.databinding.ItemListCatBinding

class ListCatAdapter: RecyclerView.Adapter<ListCatViewHolder>() {

    private val catList: MutableList<Cat> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCatViewHolder {
        val itemView = ItemListCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListCatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListCatViewHolder, position: Int) {
       holder.bind(catList[position])
    }

    override fun getItemCount() =  catList.size

    fun setCats(cats: List<Cat>) {
        this.catList.clear()
        this.catList.addAll(cats)
        notifyDataSetChanged()
    }
}

class ListCatViewHolder(private val view: ItemListCatBinding) : RecyclerView.ViewHolder(view.root){

    fun bind(cat: Cat) {
        Log.d("teste",cat.image)
        view.catImage.load(cat.image) {
            crossfade(true)
        }
        view.catName.text = cat.name
    }
}