package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.databinding.ItemCoinBinding

class CoinAdapter () : ListAdapter<CoinModelResponse, CoinAdapter.ViewHolderCoin>(diffCallback) {
    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<CoinModelResponse>(){
            override fun areItemsTheSame(
                oldItem: CoinModelResponse,
                newItem: CoinModelResponse,
            ): Boolean {
                return oldItem.nameCoin == newItem.nameCoin
            }

            override fun areContentsTheSame(
                oldItem: CoinModelResponse,
                newItem: CoinModelResponse,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.ViewHolderCoin {
            return ViewHolderCoin(ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderCoin, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderCoin(val binding: ItemCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(information: CoinModelResponse) {
            binding.apply {
                tvNameCoin.setText(information.nameCoin)
                tvMiniumAmount.setText(information.miniumAmount?: "0.0")
                tvMaximunAmount.setText(information.maximumAmount?: "0.0")
                tvMiniumPrice.setText(information.miniumPrice?: "0.0")
                tvMaximunPrice.setText(information.maxiumPrice?: "0.0")
                tvMiniumValue.setText(information.miniumValue?: "0.0")
                tvMaximunValue.setText(information.maximunValue?: "0.0")
            }
        }
    }
}