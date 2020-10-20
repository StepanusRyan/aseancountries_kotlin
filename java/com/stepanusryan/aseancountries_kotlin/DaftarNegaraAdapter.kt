package com.stepanusryan.aseancountries_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stepanusryan.aseancountries_kotlin.DaftarNegaraAdapter.DaftarViewHolder
import java.util.*

class DaftarNegaraAdapter(private val daftarNegara: ArrayList<Negara>) : RecyclerView.Adapter<DaftarViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback?) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaftarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_negara_asean, parent, false)
        return DaftarViewHolder(view)
    }

    override fun onBindViewHolder(holder: DaftarViewHolder, position: Int) {
        val negara = daftarNegara[position]
        Glide.with(holder.itemView.context)
                .load(negara.foto)
                .apply(RequestOptions().override(60, 60))
                .into(holder.img)
        holder.negara.text = negara.nama
        holder.ibukota.text = negara.ibukota
        holder.itemView.setOnClickListener { onItemClickCallback!!.onItemClicked(daftarNegara[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return daftarNegara.size
    }
    inner class DaftarViewHolder(view: View) : ViewHolder(view) {
        var img: ImageView = view.findViewById(R.id.img_bendera)
        var negara: TextView = view.findViewById(R.id.txtNegara)
        var ibukota: TextView = view.findViewById(R.id.txtIbuKota)
    }

    interface OnItemClickCallback {
        fun onItemClicked(negara: Negara?)
    }
}