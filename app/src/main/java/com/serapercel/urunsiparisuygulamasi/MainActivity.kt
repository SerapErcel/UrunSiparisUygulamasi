package com.serapercel.urunsiparisuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import com.serapercel.urunsiparisuygulamasi.adapter.CustomAdapter
import com.serapercel.urunsiparisuygulamasi.configs.ApiClient
import com.serapercel.urunsiparisuygulamasi.services.DummyService
import com.serapercel.uruntanitimuygulamasi.models.DummyProducts
import com.serapercel.uruntanitimuygulamasi.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listView: ListView
    lateinit var btnCart: Button
    lateinit var list: List<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvProducts)
        btnCart = findViewById(R.id.btnCart)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        dummyService.products().enqueue(object : Callback<DummyProducts> {
            override fun onResponse(call: Call<DummyProducts>, response: Response<DummyProducts>) {
                val datas = response.body()
                list = datas!!.products
                val customAdapter = CustomAdapter(this@MainActivity, list)
                listView.adapter = customAdapter

            }

            override fun onFailure(call: Call<DummyProducts>, t: Throwable) {
                Log.e("dummyService", t.toString())
            }
        })


        btnCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", i)
            startActivity(intent)
        }
    }
}