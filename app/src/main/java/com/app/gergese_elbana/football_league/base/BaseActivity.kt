package com.app.gergese_elbana.football_league.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initUi()
        addApiCall()
        setUpClicks()
        observer()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this, layoutId())
        binding.lifecycleOwner = this
    }

    abstract fun layoutId(): Int
    abstract fun initUi()
    abstract fun addApiCall()
    abstract fun setUpClicks()
    abstract fun observer()


}