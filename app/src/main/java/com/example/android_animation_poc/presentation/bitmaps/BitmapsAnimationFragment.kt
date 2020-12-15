package com.example.android_animation_poc.presentation.bitmaps

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.android_animation_poc.R
import com.example.android_animation_poc.databinding.FragmentBitmapsAnimationBinding

class BitmapsAnimationFragment : Fragment() {

    private lateinit var binding: FragmentBitmapsAnimationBinding
    private lateinit var volumeAnimation: AnimationDrawable

    private var isPlay = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBitmapsAnimationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.player.icVolume.apply {
//            setBackgroundResource(R.drawable.audio_anitmation)
//            volumeAnimation = background as AnimationDrawable
//        }

        with(binding) {

            player.buttomPlay.setOnClickListener {
                if (isPlay) {
                    isPlay = false
                    binding.player.buttomPlay.apply {


                        setBackgroundResource(R.drawable.player_play)
//                        volumeAnimation = background as AnimationDrawable
                    }

//                    volumeAnimation.start()
                } else {
                    isPlay = true

                    binding.player.buttomPlay.apply {
                        setBackgroundResource(R.drawable.player_pause)
//                        volumeAnimation = background as AnimationDrawable
                    }

//                    volumeAnimation.start()

                }
            }
        }

    }
}