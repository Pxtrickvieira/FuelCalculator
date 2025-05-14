package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)

        val btnVoltar = findViewById<ImageButton>(R.id.image_back_consumo)
        val edtCosumo = findViewById<TextInputEditText>(R.id.tie_consumo)
        val btnProximo = findViewById<Button>(R.id.btn_proximo_consumo)

        btnVoltar.setOnClickListener {
            finish()
        }

        btnProximo.setOnClickListener {
            val consumoEdt = edtCosumo.text.toString().replace(',', '.')

            val consumo = consumoEdt.toFloatOrNull()
            if (consumo != null) {

                val preco = intent.getFloatExtra("Preço", 0f)
                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra("Preço", preco)
                intent.putExtra("Consumo", consumo)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Consumo inválido", Toast.LENGTH_LONG).show()
            }
            }
        }
    }

