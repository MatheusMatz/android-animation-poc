package com.example.android_animation_poc.presentation.sample.catlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.android_animation_poc.databinding.DialogDeleteBinding

class DialogDeleteFragment(
    private val deleteCallBack: (() -> Unit),
    private val unDoCallBack: (() -> Unit)
) : DialogFragment() {

    private lateinit var viewBinding: DialogDeleteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogDeleteBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {

            dialogDeleteButton.setOnClickListener {
                deleteCallBack()
                this@DialogDeleteFragment.dismiss()
            }

            dialogUndoButton.setOnClickListener {
                unDoCallBack()
                this@DialogDeleteFragment.dismiss()
            }
        }
    }
}