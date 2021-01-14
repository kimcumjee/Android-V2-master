package com.e.daedo.view.fragment

import com.e.daedo.R
import com.e.daedo.base.BaseFragment
import com.e.daedo.databinding.FragmentSignProfileBinding
import com.e.daedo.viewModel.SignProfileViewModel

class SignProfileFragment : BaseFragment<FragmentSignProfileBinding, SignProfileViewModel>() {
    override val viewModel: SignProfileViewModel
        get() = SignProfileViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_sign_profile

    override fun init() {
    }

    override fun observerViewModel() {
    }
}