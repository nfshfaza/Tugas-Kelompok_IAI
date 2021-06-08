package com.example.moneycomefirst

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_riwayat_transaksi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RiwayatTransaksi : Fragment() {

    private val historyAdapter = HistoryAdapter(arrayListOf())
    private var list = ArrayList<HistoryResponse>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat_transaksi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_RiwayatTransaksi.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter
        }
        Constants.instance.getHistory(Constants.constant_body).enqueue(object : Callback<ArrayList<HistoryResponse>>{

            override fun onResponse(
                call: Call<ArrayList<HistoryResponse>>,
                response: Response<ArrayList<HistoryResponse>>
            ) {
                response.body()?.let { list.addAll(it) }
                historyAdapter.updateHistoryData(list)
            }

            override fun onFailure(call: Call<ArrayList<HistoryResponse>>, t: Throwable) {
                Log.e("Error", t.localizedMessage)
            }

        })
    }
}