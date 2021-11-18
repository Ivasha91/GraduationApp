package com.ivan.graduationapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


private lateinit var bottomNav: BottomNavigationView

class CatalogFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)


        val cardsList: List<Cards> = listOf(
            Cards(R.drawable.card_1, "10P", 1),
            Cards(R.drawable.card_2, "20P", 2),
            Cards(R.drawable.card_3, "30P", 3),
            Cards(R.drawable.card_4, "40P", 4),
        )



        val cardsRecyclerView: RecyclerView = view.findViewById(R.id.catalog_items)
        cardsRecyclerView.layoutManager =
            LinearLayoutManager((activity as Activity), LinearLayoutManager.HORIZONTAL, false)
        cardsRecyclerView.addItemDecoration(
            DividerItemDecoration(
                (activity as Activity), DividerItemDecoration.HORIZONTAL
            )
        )

        bottomNav = (activity as MainActivity).findViewById(R.id.bottom_nav)

        cardsRecyclerView.adapter = CardsAdapter(cardsList, object : CatalogClickItem {
            override fun onClick(pos: Int) {
                Toast.makeText(context, "Item added", Toast.LENGTH_LONG).show()
                val bundle = Bundle()
                if ("${cardsList[pos].id}" == "") {
                } else {
                    bundle.putString("data", "${cardsList[pos].id}")
                    bundle.putString("extraData", "${cardsList[pos].price}")
                }

                bottomNav.selectedItemId = R.id.cart
                val cartFragment = CartFragment()
                cartFragment.arguments = bundle
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.main_fragment_container, cartFragment)?.commit()
            }

        })
        return view
    }


}