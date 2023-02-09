package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCoinsBinding
import com.example.myapplication.ui.adapter.AsksBidsAdapter
import com.example.myapplication.ui.adapter.CoinAdapter
import com.example.myapplication.ui.viewmodel.CoinDetailViewModel
import com.example.myapplication.ui.viewmodel.CoinViewModel

class CoinsFragment : Fragment() {
    private var _binding: FragmentCoinsBinding? = null
    private val binding get() = _binding!!
    private val coinDetailAdapter: AsksBidsAdapter by lazy { AsksBidsAdapter()}
    private val coinDetailViewModel : CoinDetailViewModel by viewModels()

    companion object {
        val TAG = CoinsFragment::class.java.canonicalName!!

        @JvmStatic
        fun newInstance() = CoinsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCoinsBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinDetailViewModel.getCoin()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers(){
        coinDetailViewModel.apply {
            coinsLiveData.observe(viewLifecycleOwner){ coinsList ->
                coinDetailAdapter.submitList(coinsList)
            }
        }
    }
}