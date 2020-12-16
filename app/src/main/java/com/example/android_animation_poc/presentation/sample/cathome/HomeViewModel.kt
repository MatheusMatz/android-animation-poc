package com.example.android_animation_poc.presentation.sample.cathome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_animation_poc.presentation.sample.dto.Cat
import com.example.android_animation_poc.presentation.sample.dto.Curiosity

class HomeViewModel : ViewModel() {

    private val _allItem = MutableLiveData<List<Curiosity>>()
    val allItem: LiveData<List<Curiosity>> get() = _allItem

    fun loadingItems() {
        val data = listOf(
            Curiosity(
                true,
                "https://welovecatsandkittens.com/wp-content/uploads/2015/10/weird-2.jpg",
                "Text 1",
                listOf(""),
                listOf("")
            ),
            Curiosity(
                false,
                "https://th.bing.com/th/id/OIP.nEmbnmdXNtW9Lkcr1eCrSgHaDt?o=6&pid=Api&rs=1",
                "Text 2",
                listOf(""),
                listOf("")
            ),
            Curiosity(
                false,
                "https://th.bing.com/th/id/OIP.LJY238h437MjfghNdqkSfQHaJJ?o=6&pid=Api&rs=1",
                "Text 1",
                listOf(""),
                listOf("")
            ), Curiosity(
                false,
                "https://th.bing.com/th/id/OIP.LJY238h437MjfghNdqkSfQHaJJ?o=6&pid=Api&rs=1",
                "Text 1",
                listOf(""),
                listOf("")
            ), Curiosity(
                false,
                "https://th.bing.com/th/id/OIP.LJY238h437MjfghNdqkSfQHaJJ?o=6&pid=Api&rs=1",
                "Text 1",
                listOf(""),
                listOf("")
            ), Curiosity(
                false,
                "https://th.bing.com/th/id/OIP.LJY238h437MjfghNdqkSfQHaJJ?o=6&pid=Api&rs=1",
                "Text 1",
                listOf(""),
                listOf("")
            ), Curiosity(
                false,
                "https://th.bing.com/th/id/OIP.LJY238h437MjfghNdqkSfQHaJJ?o=6&pid=Api&rs=1",
                "Text 1",
                listOf(""),
                listOf("")
            )
        )
        _allItem.value = data
    }
}