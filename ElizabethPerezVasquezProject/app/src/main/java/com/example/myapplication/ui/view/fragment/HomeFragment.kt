package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.view.adapter.CoinAdapter
import com.example.myapplication.ui.view.interfaces.ItemButtonCallback
import com.example.myapplication.ui.viewmodel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), ItemButtonCallback {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val coinAdapter: CoinAdapter by lazy { CoinAdapter(this) }
    private val coinViewModel: CoinViewModel by viewModels()
    private var enabled: Boolean = false
    private var nameCoin: String = ""
    private var minimumPrice: String = ""
    private var maximumPrice: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupObservers()
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinViewModel.getCoin()
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

    private fun setupObservers() {
        coinViewModel.apply {
            coinsLiveData.observe(viewLifecycleOwner) { coinsList ->
                coinAdapter.submitList(coinsList)
            }
        }
    }

    override fun onClickCheckBox(id: String, enabled: Boolean) {
        this.enabled = enabled
    }

    override fun onClickButton(
        id: String?,
        nameCoin: String?,
        minimumPrice: String?,
        maximumPrice: String?,
    ) {
        this.nameCoin = nameCoin.toString()
        this.minimumPrice = minimumPrice.toString()
        this.maximumPrice = maximumPrice.toString()
        val request = OrderRequest(enabled, nameCoin)
        val bundle = Bundle()
        bundle.putString("NAME_COIN", nameCoin)
        bundle.putString("MINIMUM_PRICE", minimumPrice)
        bundle.putString("MAXIMUM_PRICE", maximumPrice)
        bundle.putSerializable("REQUEST", request)

        val action = HomeFragmentDirections.actionHomeFragmentToCoinsFragment(
            nameCoin = nameCoin.toString(),
            minimumPrice = minimumPrice!!,
            maximumPrice = maximumPrice!!,
            request
        )
        findNavController().navigate(action)
    }
}


