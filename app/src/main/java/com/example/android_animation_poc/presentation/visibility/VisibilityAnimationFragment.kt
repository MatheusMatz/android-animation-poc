package com.example.android_animation_poc.presentation.visibility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_animation_poc.R
import com.example.android_animation_poc.databinding.FragmentVisibilityBinding
import org.koin.android.ext.android.inject

class VisibilityAnimationFragment : Fragment() {

    private val viewModel by inject<VisibilityAnimationViewModel>()
    private lateinit var viewBinding: FragmentVisibilityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentVisibilityBinding.inflate(inflater, container, false)

        with(viewBinding) {

            val adapter = ListCatAdapter()

            listCat.layoutManager = LinearLayoutManager(requireContext())
            listCat.adapter = adapter

            refreshLayout.setOnRefreshListener {
                runLayoutAnimation(listCat)
                refreshLayout.isRefreshing = false
            }

            viewModel.allItem.observe(viewLifecycleOwner, {
                adapter.setCats(it)
            })
        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadingItems()
    }

    private fun runLayoutAnimation(recycler: RecyclerView) {
        val layoutAnimationController =
            AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation_fall_down)

        recycler.layoutAnimation = layoutAnimationController
        recycler.adapter?.notifyDataSetChanged()
        recycler.scheduleLayoutAnimation()
    }
}