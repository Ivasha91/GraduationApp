package com.ivan.graduationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.content.Intent


class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val textView: TextView = view.findViewById(R.id.cart_text)
        val args = this.arguments
        val inputData = args?.get("data").toString()
        val inputExtraData = args?.get("extraData").toString()
        var outputText = "you've chosen dress № $inputData for $inputExtraData"

//test to avoid null inside data from CatalogFragment
        when (outputText) {
            "you've chosen dress № 1 for 10P" -> textView.text = outputText
            "you've chosen dress № 2 for 20P" -> textView.text = outputText
            "you've chosen dress № 3 for 30P" -> textView.text = outputText
            "you've chosen dress № 4 for 40P" -> textView.text = outputText
        }


        val cartButton: Button = view.findViewById(R.id.cart_button)
        cartButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            if (intent.resolveActivity((activity as MainActivity).getPackageManager()) != null) {
                startActivity(intent)
            }
        }

        return view
    }
}