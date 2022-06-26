package com.android.hubview.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
data class User(
    @SerializedName("login")
    val username: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("url")
    val userProfileUrl: String
)