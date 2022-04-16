package vu.pham.week6exercise.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vu.pham.week6exercise.utils.Constants

class MovieRestClient {

    private var _api : MovieAPI

    val api : MovieAPI
        get() = _api

    init {
        _api = createMovieDBService()
    }

    companion object {
        private var mInstance: MovieRestClient? = null

        fun getInstance() = mInstance ?: synchronized(this){
            mInstance ?: MovieRestClient().also { mInstance = it }
        }
    }

    private fun createMovieDBService() : MovieAPI{
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(AuthenticationInterceptor())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(MovieAPI::class.java)
    }
}