package com.example.android_animation_poc.presentation.visibility

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VisibilityAnimationViewModel : ViewModel() {

    private val _allItem = MutableLiveData<List<Cat>>()
    val allItem: LiveData<List<Cat>> get() = _allItem

    fun loadingItems() {
        val data = listOf(
            Cat(
                "https://welovecatsandkittens.com/wp-content/uploads/2015/10/weird-2.jpg",
                "Pickles",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.nEmbnmdXNtW9Lkcr1eCrSgHaDt?o=6&pid=Api&rs=1",
                "Flurry",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.LJY238h437MjfghNdqkSfQHaJJ?o=6&pid=Api&rs=1",
                "Bilbo",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.anGwrYjHWa7lVKI7NcrwzQHaFj?o=6&pid=Api&rs=1",
                "Hans Zimmer",
                ""
            ),
            Cat(
                "https://mymodernmet.com/wp/wp-content/uploads/2019/07/alexis-reynaud-standing-cats-2.jpg",
                "Pickles",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.cvPQwqnTsZn1sSOVuswDMwHaE8?o=6&pid=Api&rs=1",
                "Jingles",
                ""
            ),
            Cat(
                "https://1.bp.blogspot.com/_KLJU3hHDGVM/TDnaQHK9VLI/AAAAAAAAC_g/56tvFKFFCeg/s1600/Animals_Cats_Small_cat.jpg",
                "Bump",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.oXvnHlXCd4sqw6otX2yTiQHaE3?o=6&pid=Api&rs=1",
                "Tylto",
                ""
            ),
            Cat(
                "https://www.safehavenforcats.org/wp-content/uploads/2019/06/March-Volunteer-Information-Session-Header-1080x640-1080x640.jpg",
                "Suno",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.uNVLqmXRF4hTNvi5Z9FVWQHaI1?o=6&pid=Api&rs=1",
                "Yowmu",
                ""
            ),
            Cat(
                "https://th.bing.com/th/id/OIP.HUIgimeP9T4XW5JGANCDAwHaEK?o=6&pid=Api&rs=1",
                "Dingo",
                ""
            )
        )
        _allItem.value = data
    }
}