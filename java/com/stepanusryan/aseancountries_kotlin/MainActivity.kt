package com.stepanusryan.aseancountries_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stepanusryan.aseancountries_kotlin.DaftarNegaraAdapter.OnItemClickCallback
import com.stepanusryan.aseancountries_kotlin.DataNegara.getdata
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private val negaras = ArrayList<Negara>()
    private lateinit var ivAbout: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rvNegara)
        rv.setHasFixedSize(true)
        ivAbout = findViewById(R.id.imgAbout)
        ivAbout.setOnClickListener { startActivity(Intent(this@MainActivity, AboutActivity::class.java)) }
        negaras.addAll(getdata())
        tampilDaftarNegara()
    }
    private fun tampilDaftarNegara() {
        rv.layoutManager = LinearLayoutManager(this)
        val daftarNegaraAdapter = DaftarNegaraAdapter(negaras)
        rv.adapter = daftarNegaraAdapter
        daftarNegaraAdapter.setOnItemClickCallback(object : OnItemClickCallback {
            override fun onItemClicked(negara: Negara?) {
                detailNegara(negara)
            }
        })
    }

    private fun detailNegara(negara: Negara?) {
        val detail = Intent(this@MainActivity, DetailActivity::class.java)
        detail.putExtra(DetailActivity.NEGARA, negara!!.nama)
        detail.putExtra(DetailActivity.FOTO, negara.foto)
        detail.putExtra(DetailActivity.IBUKOTA, negara.ibukota)
        detail.putExtra(DetailActivity.DESKRIPSI, negara.deskripsi)
        detail.putExtra(DetailActivity.LAGUKEBANGSAAN, negara.lagu)
        detail.putExtra(DetailActivity.PEMIMPIN, negara.pemimpin)
        detail.putExtra(DetailActivity.SEMBOYAN, negara.semboyan)
        detail.putExtra(DetailActivity.ARTI, negara.arti)
        startActivity(detail)
    }
}