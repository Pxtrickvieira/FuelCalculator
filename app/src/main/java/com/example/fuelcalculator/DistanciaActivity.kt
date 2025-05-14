package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)

        val btnVoltar = findViewById<ImageButton>(R.id.image_back_distancia)
        val edtDistancia = findViewById<TextInputEditText>(R.id.tie_distancia)
        val btnProximo = findViewById<Button>(R.id.btn_proximo_distancia)

        btnVoltar.setOnClickListener {
            finish()
        }

        btnProximo.setOnClickListener {

            val distanciaEdt = edtDistancia.text.toString().replace(',', '.')

            val distancia = distanciaEdt.toFloatOrNull()
            if (distancia != null) {
                val preco = intent.getFloatExtra("Preço", 0f)
                val consumo = intent.getFloatExtra("Consumo", 0f)
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("Preço", preco)
                intent.putExtra("Consumo", consumo)
                intent.putExtra("Distancia", distancia)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Distância inválida", Toast.LENGTH_LONG).show()
            }
            }
        }
    }
