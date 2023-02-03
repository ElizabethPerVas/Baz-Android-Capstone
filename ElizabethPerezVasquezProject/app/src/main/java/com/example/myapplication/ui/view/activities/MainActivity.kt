package com.example.myapplication.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.view.fragment.CoinsFragment



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    companion object{
        val TAG = MainActivity::class.java.canonicalName!!
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCoin()
    }

    private fun setCoin() {
            val onClickCoinFragment = CoinsFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.contentMain, onClickCoinFragment, CoinsFragment.TAG)
                .addToBackStack(CoinsFragment.TAG).commit()
    }
}