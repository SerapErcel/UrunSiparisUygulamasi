package com.serapercel.urunsiparisuygulamasi.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.serapercel.urunsiparisuygulamasi.R
import com.serapercel.urunsiparisuygulamasi.models.CartProduct

class CartCustomAdapter (private val context: Activity, private val list: List<CartProduct>) :
    ArrayAdapter<CartProduct>(
        context,
        R.layout.list_item, list
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.list_item, null, true)

        val name = rootView.findViewById<TextView>(R.id.tvTitle)
        val price = rootView.findViewById<TextView>(R.id.tvPrice)

        val product = list.get(position)
        name.text = product.title
        price.text = product.price.toString()

        return rootView
    }
}