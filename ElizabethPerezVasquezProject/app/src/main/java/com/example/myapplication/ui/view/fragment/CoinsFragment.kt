package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentCoinsBinding
import com.example.myapplication.ui.adapter.CoinAdapter
import com.example.myapplication.ui.viewmodel.CoinViewModel

class CoinsFragment : Fragment() {
    private var _binding: FragmentCoinsBinding? = null
    private val binding get() = _binding!!
    private val coinAdapter: CoinAdapter by lazy { CoinAdapter()}
    private val coinViewModel : CoinViewModel by viewModels()

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
        initView()
        onClickCoin()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinViewModel.getCoin()
    }

    private fun onClickCoin() {
        _binding!!.rvCoins.setOnClickListener {
        }
    }

    private fun initView() {
        _binding!!.rvCoins.setHasFixedSize(false)
        _binding!!.rvCoins.layoutManager = LinearLayoutManager(context)
        _binding!!.rvCoins.adapter = coinAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers(){
        coinViewModel.apply {
            coinsLiveData.observe(viewLifecycleOwner){ coinsList ->
                coinAdapter.submitList(coinsList)
            }
        }
    }
}