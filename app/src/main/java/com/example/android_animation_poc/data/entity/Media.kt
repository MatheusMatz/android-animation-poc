package com.example.android_animation_poc.data.entity

import com.google.gson.annotations.SerializedName

data class Media (

    @SerializedName("id")
    val id: Long,

    @SerializedName("adult")
    val wasAdult: Boolean,

    @SerializedName("backdrop_path")
    val backdrop: String,

    @SerializedName("genre_ids")
    val genreIds: List<Int>,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val poster: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("video")
    val wasVideo: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Long,

    @SerializedName("popularity")
    val popularity: Double
)