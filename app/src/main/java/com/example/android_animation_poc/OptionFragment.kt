package com.example.android_animation_poc

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.android_animation_poc.databinding.FragmentOptionBinding
import com.example.android_animation_poc.presentation.sample.SampleActivity

class OptionFragment : Fragment() {

    private lateinit var binding: FragmentOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnBitmap.setOnClickListener {
                startActivity(Intent(requireActivity(), AnimationPocActivity::class.java))
            }

            btnVisibility.setOnClickListener {
                startActivity(Intent(requireActivity(), SampleActivity::class.java))
            }
        }
    }

}