package com.example.myapplication.ui.view.adapter

import android.view.LayoutInflater
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
                tvPriceAskBids.text = information.price
                tvAmountAskBids.text = information.amount
                tvOrderAskBids.text = information.oid

            }
        }
    }
}