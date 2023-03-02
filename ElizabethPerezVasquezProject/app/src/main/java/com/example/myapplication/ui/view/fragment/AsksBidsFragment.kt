package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentAsksBidsBinding
import com.example.myapplication.ui.view.adapter.AsksBidsAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AsksBidsFragment : Fragment() {

    private var _binding: FragmentAsksBidsBinding? = null
    private val binding get() = _binding!!
    private var askBidsAdapter = AsksBidsAdapter()
    private val args: AsksBidsFragmentArgs by navArgs()
    private var isAsk: Boolean = false
    private var listAsks: List<CoinDetailAskEntity> = listOf()
    private var listBids: List<CoinDetailBidsEntity> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentAsksBidsBinding.inflate(inflater, container, false)
        getDataBundle()
        initView()
        return binding.root
    }

    private fun getDataBundle() {
        requireArguments().let {
            listAsks = args.responseArrayAskBids.asks
            listBids = args.responseArrayAskBids.bids
            isAsk = args.isAsk
        }
    }

    private fun initView() {
        _binding!!.rvAskBids.setHasFixedSize(false)
        _binding!!.rvAskBids.layoutManager = LinearLayoutManager(context)
        if (isAsk) {
            askBidsAdapter.submitList(listAsks)
        } else {
            askBidsAdapter.submitList(listAsks)
        }
        _binding!!.rvAskBids.adapter = askBidsAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}