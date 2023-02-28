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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AsksBidsFragment : Fragment() {

    private var _binding: FragmentAsksBidsBinding? = null
    private val binding get() = _binding!!
    private val coinDetailAdapter: AsksBidsAdapter by lazy { AsksBidsAdapter() }
    val args: AsksBidsFragmentArgs by navArgs()

    companion object {
        val TAG = AsksBidsFragment::class.java.canonicalName!!

        @JvmStatic
        fun newInstance() = AsksBidsFragment()
    }

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
        }
    }

    private fun initView() {
        _binding!!.rvAskBids.setHasFixedSize(false)
        _binding!!.rvAskBids.layoutManager = LinearLayoutManager(context)
        _binding!!.rvAskBids.adapter = coinDetailAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}