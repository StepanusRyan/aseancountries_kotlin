package com.stepanusryan.aseancountries_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {
    private lateinit var ng: TextView
    private lateinit var ibk: TextView
    private lateinit var des: TextView
    private lateinit var lagu: TextView
    private lateinit var pem: TextView
    private lateinit var semboyan: TextView
    private lateinit var arti: TextView
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ng = findViewById(R.id.getData)
        ibk = findViewById(R.id.setIbukota)
        des = findViewById(R.id.setDesc)
        lagu = findViewById(R.id.setLagu)
        pem = findViewById(R.id.setPemimpin)
        imageView = findViewById(R.id.gambarBendera)
        semboyan = findViewById(R.id.setSemboyan)
        arti = findViewById(R.id.setArti)
        val negara = intent.getStringExtra(NEGARA)
        val bendera = intent.getIntExtra(FOTO, 0)
        val ibu = intent.getStringExtra(IBUKOTA)
        val deskr = intent.getStringExtra(DESKRIPSI)
        val lag = intent.getStringExtra(LAGUKEBANGSAAN)
        val sem = intent.getStringExtra(SEMBOYAN)
        val art = intent.getStringExtra(ARTI)
        val pemimp = intent.getStringExtra(PEMIMPIN)
        ng.text = negara
        imageView.setImageResource(bendera)
        ibk.text = ibu
        des.text = deskr
        lagu.text = lag
        pem.text = pemimp
        semboyan.text = sem
        arti.text = art
    }

    companion object {
        const val NEGARA = "negara"
        const val FOTO = "foto"
        const val IBUKOTA = "ibukota"
        const val DESKRIPSI = "deskripsi"
        const val LAGUKEBANGSAAN = "lagukebangsaan"
        const val PEMIMPIN = "pemimpin"
        const val SEMBOYAN = "semboyan"
        const val ARTI = "arti"
    }
}