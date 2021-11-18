package com.ivan.graduationapp

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(cards: Cards) {
        val cardsImageView: ImageView = itemView.findViewById(R.id.card_image)
        val cardsPriceView: TextView = itemView.findViewById(R.id.card_price)

        cardsImageView.setImageDrawable(itemView.context.getDrawable(cards.imageRes))
        cardsPriceView.text = cards.price

    }
}