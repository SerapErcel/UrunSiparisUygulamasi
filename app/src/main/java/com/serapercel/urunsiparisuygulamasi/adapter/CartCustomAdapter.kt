package com.serapercel.urunsiparisuygulamasi.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.serapercel.urunsiparisuygulamasi.R
import com.serapercel.urunsiparisuygulamasi.models.CartProduct

class CartCustomAdapter(private val context: Activity, private val list: List<CartProduct>) :
    ArrayAdapter<CartProduct>(
        context,
        R.layout.cart_list_item, list
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.cart_list_item, null, true)

        val title = rootView.findViewById<TextView>(R.id.title)
        val price = rootView.findViewById<TextView>(R.id.price)
        val quantity = rootView.findViewById<TextView>(R.id.quantity)
        val total = rootView.findViewById<TextView>(R.id.total)
        val discountPercentage = rootView.findViewById<TextView>(R.id.discountPercentage)
        val discountedPrice = rootView.findViewById<TextView>(R.id.discountedPrice)


        val product = list[position]
        title.text = product.title
        price.text = product.price.toString()
        quantity.text = product.total.toString()
        total.text = product.total.toString()
        discountPercentage.text = product.discountPercentage.toString()
        discountedPrice.text = product.discountedPrice.toString()

        return rootView
    }
}