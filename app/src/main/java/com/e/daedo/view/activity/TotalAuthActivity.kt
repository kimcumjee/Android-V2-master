package com.e.daedo.view.activity

import com.e.daedo.R
import com.e.daedo.base.BaseActivity
import com.e.daedo.databinding.ActivityTotalAuthBinding
import com.e.daedo.viewModel.TotalAuthViewModel

class TotalAuthActivity : BaseActivity<ActivityTotalAuthBinding, TotalAuthViewModel>() {

    override val viewModel: TotalAuthViewModel
        get() = TotalAuthViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_total_auth

    override fun init() {
    }

    override fun observerViewModel() {
    }


}