package com.example.moneycomefirst

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneycomefirst.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_riwayat_transaksi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {

    private lateinit var dataBinding: FragmentHomeBinding

    var new_response = HistoryResponse("", "", "", "", WalletResponse("", "", ""), "")
    var response2 = ArrayList<HistoryResponse>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Constants.instance.getHistory(Constants.constant_body).enqueue(object : Callback<ArrayList<HistoryResponse>> {

            override fun onResponse(
                call: Call<ArrayList<HistoryResponse>>,
                response: Response<ArrayList<HistoryResponse>>
            ) {
                //Log.i("response", response.body().toString())
                response.body()?.get(1)?.let { new_response }
                response.body()?.let { response2.addAll(it) }
                Log.i("response", response2[0].toString())
                dataBinding.history = response2[0]
            }

            override fun onFailure(call: Call<ArrayList<HistoryResponse>>, t: Throwable) {
                Log.e("Error", t.localizedMessage)
            }

        })

        //dataBinding.history = new_response

        btn_RiwayatTransaksi.setOnClickListener {
            val toTransaction = HomeDirections.nextactiontransaksi()
            Navigation.findNavController(view).navigate(toTransaction)
        }

        btn_TambahSaldo.setOnClickListener{
            val toTambahSaldo = HomeDirections.nextactionsaldo()
            Navigation.findNavController(view).navigate(toTambahSaldo)
        }

        btn_ScanQris.setOnClickListener{
            val toScanQr = HomeDirections.nextactionscan()
            Navigation.findNavController(view).navigate(toScanQr)
        }
    }

}