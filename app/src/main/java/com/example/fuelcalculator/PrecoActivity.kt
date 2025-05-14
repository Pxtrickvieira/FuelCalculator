package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco)

        val btnVoltar = findViewById<ImageButton>(R.id.image_back_preco)
        val edtPreco = findViewById<TextInputEditText>(R.id.tie_preco)
        val btnProximo = findViewById<Button>(R.id.btn_proximo_preco)

        btnVoltar.setOnClickListener {
            finish()
        }

        btnProximo.setOnClickListener {

            val precoEdt = edtPreco.text.toString().replace(',', '.')

            val preco = precoEdt.toFloatOrNull()
            if (preco != null) {
                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("Preço", preco)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preço inválido", Toast.LENGTH_LONG).show()
            }
        }
    }
}
