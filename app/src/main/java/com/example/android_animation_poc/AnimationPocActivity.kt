package com.example.android_animation_poc

import android.animation.*
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import com.example.android_animation_poc.databinding.ActivityAnimationPocBinding
import com.example.android_animation_poc.presentation.sample.baseView.disableViewDuringAnimation

class AnimationPocActivity : Activity() {

    private val viewBinding by lazy {
        ActivityAnimationPocBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.principalFAB.setOnClickListener {
            rotater()
        }

        viewBinding.buttonRight.setOnClickListener {
            translater()
        }
    }

    private fun rotater(): ObjectAnimator {
        val animator = ObjectAnimator.ofFloat(viewBinding.crazySquare, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.repeatCount = 3

        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                viewBinding.principalFAB.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                viewBinding.principalFAB.isEnabled = true
            }
        })

        return animator
    }

    private fun translater() {

        val animator = ObjectAnimator.ofFloat(
            viewBinding.crazySquare, View.TRANSLATION_X,
            500f
        )


        animator.repeatCount = 5
        animator.repeatMode = ObjectAnimator.REVERSE

        val animationSet = AnimatorSet()
        animationSet.playTogether(
            animator,
            rotater()
        )

        animationSet.start()
    }

    private fun scaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(
            viewBinding.crazySquare, scaleX, scaleY
        )
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(viewBinding.principalFAB)
        animator.start()
    }

    private fun fader() {
        val animator = ObjectAnimator.ofFloat(viewBinding.principalFAB, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(viewBinding.buttonRight)
        animator.start()
    }

    private fun colorizer() {
        var animator = ObjectAnimator.ofArgb(
            viewBinding.crazySquare.parent,
            "backgroundColor", Color.BLACK, Color.RED
        )

        animator.setDuration(500)
        animator.repeatCount = 10
        animator.repeatMode = ObjectAnimator.REVERSE

        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                rotater()
            }

            override fun onAnimationEnd(animation: Animator?) {
                scaler()
            }
        })
        animator.disableViewDuringAnimation(viewBinding.principalFAB)
        animator.start()
    }
}