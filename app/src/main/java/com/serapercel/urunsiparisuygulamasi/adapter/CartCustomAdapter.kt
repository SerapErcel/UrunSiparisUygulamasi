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

        val tv1 = rootView.findViewById<TextView>(R.id.textView)
        val tv2 = rootView.findViewById<TextView>(R.id.textView2)
        val tv3 = rootView.findViewById<TextView>(R.id.textView3)

        val product = list.get(position)
        tv1.text = product.title
        tv2.text = product.price.toString()
        tv3.text = product.total.toString()

        return rootView
    }
}