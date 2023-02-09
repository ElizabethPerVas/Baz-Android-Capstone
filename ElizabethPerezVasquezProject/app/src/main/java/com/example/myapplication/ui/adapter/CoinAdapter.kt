package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
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
                tvMiniumAmount.setText("$" +information.miniumPrice?: "$0.0")
                tvMaximunAmount.setText("$" +information.maxiumPrice?: "$0.0")
                when(information.nameCoin){
                    "eth_btc" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.eth))
                    "uni_usd" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.uni))
                    "xrp_btc" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.xrp))
                    "ltc_btc" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.ltc))
                    "bch_btc" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.bch))
                    "tusd_mxn" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.tusd))
                    "bat_btc" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.bat))
                    "mana_btc" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.mana))
                    "btc_ars" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.ars))
                    "dai_ars" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.dai))
                    "usd_mxn" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.usdc))
                    "aave_usd" -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.aave))
                    else -> ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.bitcoin))
                }
            }
        }
    }
}