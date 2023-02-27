package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.databinding.FragmentCoinsBinding
import com.example.myapplication.ui.viewmodel.CoinDetailViewModel
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.model.response.OrderResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragment : Fragment() {
    private var _binding: FragmentCoinsBinding? = null
    private val binding get() = _binding!!
    private val coinDetailViewModel: CoinDetailViewModel by viewModels()
    private var request: OrderRequest? = null
    var listAsks: List<CoinDetailAskEntity> = listOf()
    var listBids: List<CoinDetailBidsEntity> = listOf()
    var updateAll: String = ""
    var sequence: Long = 0L
    val args: CoinsFragmentArgs by navArgs()


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
            var bundle = Bundle()
            val response: CoinDetailEntity = CoinDetailEntity(
                ask = listAsks,
                bids = listBids,
                sequence = sequence,
                update_at = updateAll
            )
            bundle.putSerializable("RESPONSE_ORDER", response)
            bundle.putBoolean("IS_ASK", true)
            val action = CoinsFragmentDirections.actionCoinsFragmentToAsksBidsFragment(
                response
            )
            findNavController().navigate(action)
        }

        _binding?.btnBids?.setOnClickListener {
            var bundle = Bundle()
            val response: CoinDetailEntity = CoinDetailEntity(
                ask = listAsks,
                bids = listBids,
                sequence = sequence,
                update_at = updateAll
            )
            bundle.putSerializable("RESPONSE_ORDER", response)
            bundle.putBoolean("IS_ASK", false)
            val action = CoinsFragmentDirections.actionCoinsFragmentToAsksBidsFragment(
                response
            )
            findNavController().navigate(action)
        }
    }

    private fun initView() {
        _binding?.tvNameDetailCoin?.text = args.nameCoin
        _binding?.tvMiniumPrice?.text = args.miniumPrice
        _binding?.tvMaximunPrice?.text = args.maxiumPrice
    }

    private fun getDataBundle() {
        requireArguments().let {
            request = args.request
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
                _binding?.tvUpdateAt?.text = it.update_at
                _binding?.tvSequenceDetailCoin?.text = it.sequence.toString()
                listAsks = it.ask
                listBids = it.bids
                updateAll = it.update_at
                sequence = it.sequence!!
            }
        }
    }
}