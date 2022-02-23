package com.pourkazemi.mahdi.myquiz.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jakewharton.picasso.OkHttp3Downloader
import com.pourkazemi.mahdi.myquiz.databinding.ActivityMainBinding
import com.pourkazemi.mahdi.myquiz.network.FlickerResponse
import com.pourkazemi.mahdi.myquiz.network.NetworkManger
import com.squareup.picasso.Picasso
//import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//var client = OkHttpClient()

private lateinit var binding: ActivityMainBinding

//var url = "https://reqres.in/api/users/2"
class HomeViewModel : ViewModel() {

    //var picasso = Picasso.Builder(this).downloader(OkHttp3Downloader(client)).build()
init {
        val myFlicker: Call<FlickerResponse> = NetworkManger.networkMangerFlickerService
            .getFlicker(


                 "1c04e05bce6e626247758d120b372a73",
                 "flickr.photos.getPopular", "34427466731@N01",
                 "url_s",  "json",
                 "1",  "100",  "1"
            )
        myFlicker.enqueue(object : Callback<FlickerResponse?> {
            override fun onResponse(
                call: Call<FlickerResponse?>,
                response: Response<FlickerResponse?>
            ) {
                _jsonText.value= response.body()!!.photos.photo[1].url_s
                Log.d(Tag, response.body().toString())
            }

            override fun onFailure(call: Call<FlickerResponse?>, t: Throwable) {
                Log.d(Tag, "onFail")
            }
        })
}

    private val _jsonText = MutableLiveData<String>()
    val jsonText: LiveData<String> = _jsonText
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}