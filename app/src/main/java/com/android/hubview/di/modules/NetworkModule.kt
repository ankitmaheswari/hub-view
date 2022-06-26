package com.android.hubview.di.modules

import com.android.hubview.BuildConfig
import com.android.hubview.repository.PullRequestsApi
import com.android.hubview.utils.Config
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", Config.AUTH_TOKEN)
                    .build()
                chain.proceed(request)
            }
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesPullRequestApi(retrofit: Retrofit): PullRequestsApi {
        return retrofit.create(PullRequestsApi::class.java)
    }
}