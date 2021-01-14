package com.e.daedo.view.fragment


import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.navigation.fragment.findNavController
import cn.pedant.SweetAlert.SweetAlertDialog
import com.e.daedo.R
import com.e.daedo.base.BaseFragment
import com.e.daedo.databinding.FragmentLoginBinding
import com.e.daedo.viewModel.LoginViewModel
import com.e.daedo.widget.Sha512
import kotlinx.android.synthetic.main.fragment_login.*
import kotlin.math.log


class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override var viewModel: LoginViewModel = LoginViewModel()
    override val layoutRes: Int = R.layout.fragment_login
    private val sha512class = Sha512()
//    val sweetAlertDialog = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)

    override fun init() {

    }

    override fun observerViewModel() {
        login_btn.setBackgroundResource(R.drawable.login_button_disabled)
        login_btn.isEnabled = false

        edit_text_text_email_address.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                checkEmpty()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                checkEmpty()
            }

        })

        edit_text_text_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                checkEmpty()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                checkEmpty()
            }

        })

        login_btn.setOnClickListener {
            viewModel.login(binding.editTextTextEmailAddress.text.toString(), sha512class.sha512(binding.editTextTextPassword.text.toString()))
//            sweetAlertDialog.progressHelper.barColor = Color.parseColor("#0DE930")
//            sweetAlertDialog
//                .setTitleText("로딩 중")
//                .setCancelable(false)
//            sweetAlertDialog.show()
        }
        x_btn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_authManagerFragment)
        }
    }

    private fun checkEmpty() {
        if (binding.editTextTextPassword.text.toString()
                .isNotEmpty() && binding.editTextTextEmailAddress.text.toString().isNotEmpty()
        ) {
            login_btn.setBackgroundResource(R.drawable.login_button)
            login_btn.isEnabled = true
        } else {
            login_btn.setBackgroundResource(R.drawable.login_button_disabled)
            login_btn.isEnabled = false
        }
    }
}