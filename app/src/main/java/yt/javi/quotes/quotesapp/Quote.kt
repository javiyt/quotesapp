package yt.javi.quotes.quotesapp

import com.google.gson.annotations.SerializedName


data class Quote(
        @SerializedName("ID") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("content") val content: String,
        @SerializedName("link") val link: String
)