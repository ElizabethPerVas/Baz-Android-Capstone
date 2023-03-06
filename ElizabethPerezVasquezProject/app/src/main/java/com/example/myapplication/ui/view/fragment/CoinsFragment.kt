package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.databinding.FragmentCoinsBinding
import com.example.myapplication.ui.viewmodel.CoinDetailViewModel
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.example.myapplication.data.database.entities.CoinDetailEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragment : Fragment() {
    private var _binding: FragmentCoinsBinding? = null
    private val binding get() = _binding!!
    private val coinDetailViewModel: CoinDetailViewModel by viewModels()
    private var request: OrderRequest? = null
    var nameCoin: String = ""
    var minimumPrice: String = ""
    var maximumPrice: String = ""
    private var imageCoin: Int = 0
    private var listAsks: List<CoinDetailAskEntity> = listOf()
    private var listBids: List<CoinDetailBidsEntity> = listOf()
    private var updateAll: String = ""
    private var sequence: String = ""
    private val args: CoinsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentCoinsBinding.inflate(inflater, container, false)
        getDataBundle()
        setupObservers()
        initView()
        onClick()
        return binding.root
    }

    private fun onClick() {
        _binding?.btnAsk?.setOnClickListener {
            val bundle = Bundle()
            val response = CoinDetailEntity(
                asks = listAsks,
                bids = listBids,
                sequence = sequence,
                updated_at = updateAll
            )
            bundle.putSerializable("RESPONSE_ORDER", response)
            bundle.putBoolean("IS_ASK", true)
            val action = CoinsFragmentDirections.actionCoinsFragmentToAsksBidsFragment(
                response,
                isAsk = true
            )
            findNavController().navigate(action)
        }

        _binding?.btnBids?.setOnClickListener {
            val bundle = Bundle()
            val response = CoinDetailEntity(
                asks = listAsks,
                bids = listBids,
                sequence = sequence,
                updated_at = updateAll
            )
            bundle.putSerializable("RESPONSE_ORDER", response)
            bundle.putBoolean("IS_ASK", false)
            val action = CoinsFragmentDirections.actionCoinsFragmentToAsksBidsFragment(
                response,
                isAsk = false
            )
            findNavController().navigate(action)
        }
    }

    private fun initView() {
        _binding?.tvNameDetailCoin?.text = nameCoin
        _binding?.tvMiniumPrice?.text = minimumPrice
        _binding?.tvMaximunPrice?.text = maximumPrice
    }

    private fun getDataBundle() {
        requireArguments().let {
            request = args.request
            nameCoin = args.nameCoin
            minimumPrice = args.minimumPrice
            maximumPrice = args.maximumPrice
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinDetailViewModel.getDetailCoin(request!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        coinDetailViewModel.apply {
            coinsDetailLiveData.observe(viewLifecycleOwner) {
                _binding?.tvUpdateAt?.text = it.updated_at.split("T1", "T2", "T0")[0]
                _binding?.tvSequenceDetailCoin?.text = it.sequence
                listAsks = it.asks
                listBids = it.bids
                updateAll = it.updated_at
                sequence = it.sequence
            }
        }
    }
}
