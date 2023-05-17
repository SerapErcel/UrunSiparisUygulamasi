package com.serapercel.urunsiparisuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.serapercel.urunsiparisuygulamasi.configs.ApiClient
import com.serapercel.urunsiparisuygulamasi.models.RequestCart
import com.serapercel.urunsiparisuygulamasi.models.RequestProduct
import com.serapercel.urunsiparisuygulamasi.services.DummyService
import com.serapercel.uruntanitimuygulamasi.models.DummyProducts
import com.serapercel.uruntanitimuygulamasi.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {


    lateinit var dummyService: DummyService
    lateinit var tvTitle: TextView
    lateinit var tvPrice: TextView
    lateinit var tvDesc: TextView
    lateinit var tvCategory: TextView
    lateinit var btnAddCart: Button
    lateinit var img: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvTitle = findViewById(R.id.tvProductTitle)
        tvPrice = findViewById(R.id.tvProductPrice)
        tvDesc = findViewById(R.id.tvProductDesc)
        tvCategory = findViewById(R.id.tvProductCategory)
        btnAddCart = findViewById(R.id.btnAddCart)
        img = findViewById(R.id.ivProduct)

        val id = intent.getIntExtra("id", 1) + 1

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.singleProduct(id).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                val product = response.body()
                if (product != null) {
                    tvTitle.text = product.title
                    tvCategory.text = product.category
                    tvDesc.text = product.description
                    tvPrice.text = product.price.toString()

                    Glide.with(this@DetailActivity).load(product.images[0]).into(img)
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "Hata", Toast.LENGTH_SHORT).show()
            }

        })

        btnAddCart.setOnClickListener {

            var cartProducts = RequestCart(userId = 1, listOf(RequestProduct(id, 1)))


            dummyService.addCart(cartProducts).enqueue(object : Callback<RequestCart> {
                override fun onResponse(
                    call: Call<RequestCart>,
                    response: Response<RequestCart>
                ) {
                    Log.d("test", response.toString())
                }

                override fun onFailure(call: Call<RequestCart>, t: Throwable) {

                }

            })
        }
    }
}