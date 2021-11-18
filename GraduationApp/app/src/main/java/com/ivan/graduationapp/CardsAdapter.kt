package com.ivan.graduationapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CardsAdapter(
    private val cardsList: List<Cards>,
    private val catalogClickItem: CatalogClickItem
) : RecyclerView.Adapter<CardsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val cardsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_list_item, parent, false)

        return CardsViewHolder(cardsView)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val card = cardsList[position]
        holder.bind(card)

        holder.itemView.setOnClickListener {
            catalogClickItem.onClick(position)
        }

    }

    override fun getItemCount(): Int {
        return cardsList.size
    }
}