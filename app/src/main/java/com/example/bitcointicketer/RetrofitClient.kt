package com.example.bitcointicketer

import com.example.bitcointicketer.Objects.Currencies
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitClient {
    companion object {
        val BASE_URL:String="https://blockchain.info/"
        var longerTimeoutClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        var gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        var retrofitApiInstance = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(longerTimeoutClient)
            .build()
        fun create(): RetrofitClient{
            return retrofitApiInstance.create(RetrofitClient::class.java)
        }
    }
    @GET("ticker")
    fun getBitcoinData(): Call<Currencies>

}