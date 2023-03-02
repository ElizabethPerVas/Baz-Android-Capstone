package com.example.myapplication.ui.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.databinding.ItemAsksBinding

class AsksBidsAdapter :
    ListAdapter<CoinDetailAskEntity, AsksBidsAdapter.ViewHolderCoin>(diffCallback) {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CoinDetailAskEntity>() {
            override fun areItemsTheSame(
                oldItem: CoinDetailAskEntity,
                newItem: CoinDetailAskEntity,
            ): Boolean {
                return oldItem.book == newItem.book
            }

            override fun areContentsTheSame(
                oldItem: CoinDetailAskEntity,
                newItem: CoinDetailAskEntity,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCoin {
        return ViewHolderCoin(
            ItemAsksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderCoin, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderCoin(private val binding: ItemAsksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(information: CoinDetailAskEntity) {
            binding.apply {
                tvNameCoinAskBids.text = information.book
                Log.e("TAG_APP", "book: " + information.book)
                Log.e("TAG_APP", "price: " + information.price)
                Log.e("TAG_APP", "oid: " + information.oid)
                Log.e("TAG_APP", "amount: " + information.amount)

                tvPriceAskBids.text = information.price
                tvAmountAskBids.text = information.amount
                if (information.oid!!.isEmpty()) {
                    tvOrderAskBids.visibility = View.GONE
                } else {
                    tvOrderAskBids.text = information.oid

                }
            }
        }
    }
}