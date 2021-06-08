package com.example.moneycomefirst

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
        var state = false

        btn_login.setOnClickListener{
            val email = tf_email.text.toString()
            val password = tf_password.text.toString()
            Constants.instance.createLogin(email, password).enqueue(object : Callback<CreateLoginResponse>{
                override fun onResponse(
                    call: Call<CreateLoginResponse>,
                    response: Response<CreateLoginResponse>
                ) {
                    var token = response.body()
                    state = true
                }

                override fun onFailure(call: Call<CreateLoginResponse>, t: Throwable) {

                }

            })

            if (state == true){
                val action = LoginDirections.actionlogin()
                Navigation.findNavController(view).navigate(action)
            }
        }
    }


}