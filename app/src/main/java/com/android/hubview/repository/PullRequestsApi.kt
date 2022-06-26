package com.android.hubview.repository

import com.android.hubview.data.PullRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
interface PullRequestsApi {

    @GET("/repos/{owner}/{repo}/pulls?state=closed")
    suspend fun getClosedPullRequests(@Path("owner") repoOwner: String,
                                      @Path("repo") repo: String,
                                      @Query("page") pageNumber: Int=1,
                                      @Query("per_page") itemsPerPage: Int=10): Response<List<PullRequest>>
}