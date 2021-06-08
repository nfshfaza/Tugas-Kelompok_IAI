package com.example.moneycomefirst

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*


class Home : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_RiwayatTransaksi.setOnClickListener {
            val toTransaction = HomeDirections.nextactiontransaksi()
            Navigation.findNavController(view).navigate(toTransaction)
        }

        btn_TambahSaldo.setOnClickListener{
            val toTambahSaldo = HomeDirections.nextactionsaldo()
            Navigation.findNavController(view).navigate(toTambahSaldo)
        }
    }

}