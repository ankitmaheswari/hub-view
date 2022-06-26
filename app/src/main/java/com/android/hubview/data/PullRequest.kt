package com.android.hubview.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
data class PullRequest(
    @SerializedName("html_url")
    val pullRequestUrl: String,

    @SerializedName("number")
    val pullRequestNumber: Long,

    @SerializedName("title")
    val pullRequestTitle: String,

    @SerializedName("body")
    val pullRequestDesc: String,

    @SerializedName("user")
    val author:User,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("closed_at")
    val closedAt: String
)