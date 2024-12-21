package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySpinnerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerExibicao()

        with(binding) {

            btnEnviarSpinner.setOnClickListener {

                spinnerSelecionarItem()

            }

        }

    }

    private fun spinnerSelecionarItem() {

        val itemSelecionado = binding.spinnerCategorias.selectedItem
        val itemPosicao = binding.spinnerCategorias.selectedItemPosition

        if (itemPosicao == 0) {
            Toast.makeText(this, "Por favor escolha um dos ninjas", Toast.LENGTH_SHORT).show()
        } else {
            binding.textResultadoSpinner.text = "Selecionado: $itemSelecionado | Posição: $itemPosicao"
            Toast.makeText(this, "$itemSelecionado selecionado", Toast.LENGTH_SHORT).show()
        }

    }

    private fun spinnerExibicao() {

        val ninjas = listOf(
            "-- Selecione um ninja --", "Shisui", "Minato", "Tobirama", "Nagato", "Yahiko"
        )

        binding.spinnerCategorias.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            ninjas
        )

    }
}