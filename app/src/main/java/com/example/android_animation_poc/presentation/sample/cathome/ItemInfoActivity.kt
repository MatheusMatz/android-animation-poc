package com.example.android_animation_poc.presentation.sample.cathome

import android.app.Activity
import android.os.Bundle
import android.transition.TransitionInflater
import android.transition.TransitionSet
import android.widget.ImageView
import android.widget.Toast
import coil.load
import com.example.android_animation_poc.R
import com.example.android_animation_poc.databinding.ActivityItemInfoBinding
import com.example.android_animation_poc.presentation.sample.baseView.RadiusTransition
import com.example.android_animation_poc.presentation.sample.dto.Curiosity

class ItemInfoActivity : Activity() {

    private lateinit var viewBinding: ActivityItemInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.sharedElementEnterTransition = baseInterpolator()
            .addTransition(RadiusTransition.toSquare())

        window.sharedElementReturnTransition =
            baseInterpolator()
                .addTransition(RadiusTransition.toCircle())

            viewBinding = ActivityItemInfoBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)


    }

    override fun onResume() {
        super.onResume()

        val serializableExtra = intent.getSerializableExtra("INFO")

        if (serializableExtra is Curiosity) {
            Toast.makeText(this, serializableExtra.title, Toast.LENGTH_LONG).show()
            with(viewBinding) {
                itemInfoImage.load(serializableExtra.image)
                itemInfoTitle.text = serializableExtra.title
            }
        }
    }

    private fun baseInterpolator(): TransitionSet =
        TransitionInflater.from(this)
            .inflateTransition(R.transition.image_shared_element_transition) as TransitionSet
}