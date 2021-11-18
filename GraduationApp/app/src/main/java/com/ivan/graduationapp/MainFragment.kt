package com.ivan.graduationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var bottomNav: BottomNavigationView

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        bottomNav = (activity as MainActivity).findViewById(R.id.bottom_nav)

        val catalogBtn: Button = view.findViewById(R.id.go_to_catalog_button)
        catalogBtn.setOnClickListener {
            (activity as MainActivity).replaceFragment(CatalogFragment())
            bottomNav.selectedItemId = R.id.catalog
        }
        return view
    }

}