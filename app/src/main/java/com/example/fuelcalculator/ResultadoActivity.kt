package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)


        val preco = intent.getFloatExtra("Preço", 0f)
        val consumo = intent.getFloatExtra("Consumo", 0f)
        val distancia = intent.getFloatExtra("Distancia", 0f)


        val custoViagem = if (consumo != 0f && distancia != 0f && preco != 0f) {
            (distancia / consumo) * preco
        } else {
            0f
        }

        val txtResultado = findViewById<TextView>(R.id.txt_resultado)
        val txtPrecoResult = findViewById<TextView>(R.id.txt_result_valor)
        val txtConsumoResult = findViewById<TextView>(R.id.txt_result_consumo)
        val txtKmResult = findViewById<TextView>(R.id.txt_result_km)


        txtPrecoResult.text = preco.toString()
        txtConsumoResult.text = consumo.toString()
        txtKmResult.text = distancia.toString()

        txtResultado.text = String.format("$%.2f", custoViagem)

        val btnProximo = findViewById<Button>(R.id.btn_proximo_resultado)
        btnProximo.setOnClickListener {
            val intent = Intent(this, PrecoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}