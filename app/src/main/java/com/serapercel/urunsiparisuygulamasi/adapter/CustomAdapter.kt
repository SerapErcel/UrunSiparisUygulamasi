package com.serapercel.urunsiparisuygulamasi.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.serapercel.urunsiparisuygulamasi.R
import com.serapercel.uruntanitimuygulamasi.models.Product

class CustomAdapter(private val context: Activity, private val list: List<Product>) :
    ArrayAdapter<Product>(
        context,
        R.layout.list_item, list
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.list_item, null, true)

        val name = rootView.findViewById<TextView>(R.id.tvTitle)
        val price = rootView.findViewById<TextView>(R.id.tvPrice)
        val image = rootView.findViewById<ImageView>(R.id.imageView)

        val product = list.get(position)
        name.text = product.title
        price.text = product.price.toString()

        Glide.with(rootView).load(product.images[0]).into(image)

        return rootView
    }
}