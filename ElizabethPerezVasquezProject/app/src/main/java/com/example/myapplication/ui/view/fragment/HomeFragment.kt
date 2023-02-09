package com.example.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.adapter.CoinAdapter
import com.example.myapplication.ui.view.interfaces.ItemButtonCallback
import com.example.myapplication.ui.viewmodel.CoinViewModel

class HomeFragment : Fragment(), ItemButtonCallback {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val coinAdapter: CoinAdapter by lazy { CoinAdapter(this)}
    private val coinViewModel : CoinViewModel by viewModels()

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
        initImage()
        onClickCoin()
        return binding.root
    }

    private fun initImage() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinViewModel.getCoin()
    }

    private fun onClickCoin() {

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

    override fun onClickCheckBox(id: String, enabled: Boolean) {

    }

    override fun onClickButton(id: String?) {
        val onClickCoinFragment = CoinsFragment.newInstance()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.drawer_layout, onClickCoinFragment, CoinsFragment.TAG)
            .addToBackStack(CoinsFragment.TAG)
            .commit()
    }
}