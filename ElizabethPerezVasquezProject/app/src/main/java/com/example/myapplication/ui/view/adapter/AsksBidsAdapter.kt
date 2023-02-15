package com.example.myapplication.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.response.OrderResponse
import com.example.myapplication.databinding.ItemAsksBinding

class AsksBidsAdapter () : ListAdapter<OrderResponse, AsksBidsAdapter.ViewHolderCoin>(diffCallback) {
    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<OrderResponse>(){
            override fun areItemsTheSame(
                oldItem: OrderResponse,
                newItem: OrderResponse,
            ): Boolean {
                return oldItem.ask == newItem.ask
            }

            override fun areContentsTheSame(
                oldItem: OrderResponse,
                newItem: OrderResponse,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCoin {
            return ViewHolderCoin(ItemAsksBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderCoin, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderCoin(val binding: ItemAsksBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(information: OrderResponse) {
            binding.apply {
                if (!information.ask.isNullOrEmpty()) {

                }
            }
        }
    }
}