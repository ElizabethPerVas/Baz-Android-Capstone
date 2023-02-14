package com.example.myapplication.ui.view.interfaces

interface ItemButtonCallback {
    fun onClickCheckBox(id: String, enabled: Boolean)
    fun onClickButton(id: String?, nameCoin: String?, miniumPrice: String?, maxiumPrice: String?)
}