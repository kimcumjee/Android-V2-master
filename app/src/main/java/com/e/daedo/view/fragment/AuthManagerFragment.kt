package com.e.daedo.view.fragment


import androidx.navigation.fragment.findNavController
import com.e.daedo.R
import com.e.daedo.base.BaseFragment
import com.e.daedo.databinding.FragmentAuthManagerBinding
import com.e.daedo.viewModel.AuthManagerViewModel
import kotlinx.android.synthetic.main.fragment_auth_manager.*


class AuthManagerFragment : BaseFragment<FragmentAuthManagerBinding, AuthManagerViewModel>() {
    override val viewModel: AuthManagerViewModel = AuthManagerViewModel()
    override val layoutRes: Int = R.layout.fragment_auth_manager

    override fun init() {

    }

    override fun observerViewModel() {
        email_btn.setOnClickListener {
            findNavController().navigate(R.id.action_authManagerFragment_to_loginFragment)
        }
        register_btn.setOnClickListener {
            findNavController().navigate(R.id.action_authManagerFragment_to_signUpFragment)
        }
    }
}
