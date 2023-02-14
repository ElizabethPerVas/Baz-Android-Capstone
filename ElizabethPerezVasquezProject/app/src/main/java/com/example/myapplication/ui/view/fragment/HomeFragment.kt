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
import com.example.myapplication.ui.adapter.CoinAdapter
import com.example.myapplication.ui.view.interfaces.ItemButtonCallback
import com.example.myapplication.ui.viewmodel.CoinViewModel

class HomeFragment : Fragment(), ItemButtonCallback {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val coinAdapter: CoinAdapter by lazy { CoinAdapter(this) }
    private val coinViewModel: CoinViewModel by viewModels()
    private var enabled: Boolean = false
    private var nameCoin: String = ""
    private var miniumPrice: String = ""
    private var maxiumPrice: String = ""

    companion object {
        val TAG = HomeFragment::class.java.canonicalName!!

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
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
        miniumPrice: String?,
        maxiumPrice: String?,
    ) {
        this.nameCoin = nameCoin.toString()
        this.miniumPrice = miniumPrice.toString()
        this.maxiumPrice = maxiumPrice.toString()
        val request = OrderRequest(enabled, nameCoin)
        var bundle = Bundle()
        bundle.putString("NAME_COIN", nameCoin)
        bundle.putString("MINIUM_PRICE", miniumPrice)
        bundle.putString("MAXIUM_PRICE", maxiumPrice)
        bundle.putSerializable("REQUEST", request)

        val action = HomeFragmentDirections.actionHomeFragmentToCoinsFragment(
            nameCoin.toString(),
            miniumPrice.toString(),
            maxiumPrice.toString(),
            request
        )
        findNavController().navigate(action)
    }
}



