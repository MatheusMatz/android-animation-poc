package com.example.android_animation_poc.presentation.sample.cathome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
import com.example.android_animation_poc.R
import com.example.android_animation_poc.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val viewModel by inject<HomeViewModel>()
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            val gridAdapter = GridAdapter { makeTransiction() }
            val gridLayoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (gridAdapter.getItemViewType(position)) {
                        GridAdapter.TYPE_PRINCIPAL -> 2
                        GridAdapter.TYPE_SECONDARY -> 1
                        else -> -1
                    }
                }
            }

            homeGrid.adapter = gridAdapter
            homeGrid.layoutManager = gridLayoutManager

            viewModel.allItem.observe(viewLifecycleOwner, {
                gridAdapter.setItems(it)
            })

            viewModel.loadingItems()
        }
    }

    private fun makeTransiction() {
//        Toast.makeText(requireContext(), "Teste", Toast.LENGTH_LONG).show()
//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .setReorderingAllowed(true)
////            .addSharedElement()
    }
}