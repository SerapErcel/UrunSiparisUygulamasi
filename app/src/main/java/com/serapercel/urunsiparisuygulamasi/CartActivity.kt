package com.serapercel.urunsiparisuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.serapercel.urunsiparisuygulamasi.adapter.CartCustomAdapter
import com.serapercel.urunsiparisuygulamasi.adapter.CustomAdapter
import com.serapercel.urunsiparisuygulamasi.configs.ApiClient
import com.serapercel.urunsiparisuygulamasi.models.DummyCart
import com.serapercel.urunsiparisuygulamasi.services.DummyService
import com.serapercel.uruntanitimuygulamasi.models.DummyProducts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        listView = findViewById(R.id.lvCart)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        dummyService.getCart().enqueue(object : Callback<DummyCart> {
            override fun onResponse(call: Call<DummyCart>, response: Response<DummyCart>) {
                val datas = response.body()
                val list = datas!!.products
                val customAdapter = CartCustomAdapter(this@CartActivity, list!!)
                listView.adapter = customAdapter
            }

            override fun onFailure(call: Call<DummyCart>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}