package com.example.moneycomefirst

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.riwayattransaksicard.view.*

class HistoryAdapter(private val list: ArrayList<HistoryResponse>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){
    fun updateHistoryData(newData: ArrayList<HistoryResponse>) {
        list.clear()
        newData?.let { list.addAll(it) }
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun bind(historyResponse: HistoryResponse){
            with(itemView){
                val idTransaksi = historyResponse.transactions_id
                tv_idTransaksi.text = idTransaksi.toString()

                val tanggalTransaksi = historyResponse.timestamp
                tv_TanggalTransaksi.text = tanggalTransaksi

                val transaksi_username = historyResponse.wallet.name
                tv_transaksi_userName.text = transaksi_username

                val status_transaksi = historyResponse.transactions_type
                tv_StatusTransaksi.text = status_transaksi

                val nominal_transaksi = historyResponse.value
                tv_NominalTransaksi.text = nominal_transaksi
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.riwayattransaksicard, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}