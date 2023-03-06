package com.example.myapplication.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Coin
import com.example.myapplication.databinding.ItemCoinBinding
import com.example.myapplication.ui.view.interfaces.ItemButtonCallback


class CoinAdapter(private val callback: ItemButtonCallback) :
    ListAdapter<Coin, CoinAdapter.ViewHolderCoin>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Coin>() {
            override fun areItemsTheSame(
                oldItem: Coin,
                newItem: Coin,
            ): Boolean {
                return oldItem.nameCoin == newItem.nameCoin
            }

            override fun areContentsTheSame(
                oldItem: Coin,
                newItem: Coin,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCoin {
        return ViewHolderCoin(
            ItemCoinBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderCoin, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderCoin(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(information: Coin) {
            binding.apply {
                tvNameCoin.text = information.nameCoin
                tvMiniumAmount.text =
                    binding.root.context.getString(R.string.Money) + information.minimumPrice
                tvMaximunAmount.text =
                    binding.root.context.getString(R.string.Money) + information.maximumPrice
                val icon = when (information.nameCoin) {
                    "eth_btc" -> R.drawable.eth
                    "eth_mxn" -> R.drawable.eth
                    "uni_usd" -> R.drawable.uni
                    "xrp_btc" -> R.drawable.xrp
                    "xrp_usd" -> R.drawable.xrp
                    "xrp_mxn" -> R.drawable.xrp
                    "ltc_btc" -> R.drawable.ltc
                    "ltc_mxn" -> R.drawable.ltc
                    "bch_btc" -> R.drawable.bch
                    "bch_mxn" -> R.drawable.bch
                    "tusd_mxn" -> R.drawable.tusd
                    "bat_btc" -> R.drawable.bat
                    "bat_mxn" -> R.drawable.bat
                    "mana_btc" -> R.drawable.mana
                    "mana_mxn" -> R.drawable.mana
                    "btc_ars" -> R.drawable.ars
                    "mxn_ars" -> R.drawable.ars
                    "dai_ars" -> R.drawable.dai
                    "dai_mxn" -> R.drawable.dai
                    "usd_mxn" -> R.drawable.usdc
                    "btc_usd" -> R.drawable.usdc
                    "aave_usd" -> R.drawable.aave
                    else -> R.drawable.bitcoin
                }
                ivCoin.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        icon
                    )
                )
                ivCoin.setImageDrawable(ContextCompat.getDrawable(binding.root.context, icon))
                val idCheckBox = "CheckboxAggregate"
                val idBtn = "BtnShowMore"

                btnDetail.setOnClickListener {
                    callback.onClickButton(
                        idBtn,
                        information.nameCoin,
                        information.minimumPrice,
                        information.maximumPrice
                    )
                }
                cbAggregate.setOnClickListener {
                    val isChecked = cbAggregate.isChecked
                    callback.onClickCheckBox(
                        idCheckBox, isChecked
                    )
                }
            }
        }
    }
}