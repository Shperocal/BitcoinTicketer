package com.example.bitcointicketer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bitcointicketer.Objects.Currencies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun fetchData():LiveData<Currencies?>{
        val data = MutableLiveData<Currencies?>()
        var apiService:RetrofitClient= RetrofitClient.create()
        var mCallGetData: Call<Currencies> = apiService.getBitcoinData()
        mCallGetData.enqueue(object : Callback<Currencies?> {
            override fun onFailure(call: Call<Currencies?>, t: Throwable) {
                Log.d("Error",t.message.toString())
                 data.value=null
            }

            override fun onResponse(call: Call<Currencies?>, response: Response<Currencies?>) {
                Log.d("Success","")
                var currencies: Currencies?=response.body()
                data.value=currencies
            }


        } );
        return data
    }
}