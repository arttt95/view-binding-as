package com.arttt95.aulaviewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivitySwitchToggleButtonBinding

class SwitchToggleButtonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySwitchToggleButtonBinding.inflate(layoutInflater)
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

        with(binding) {

            /*btnEnviarSwitch.setOnClickListener {

                switchToggle()

            }

            switchNotificacoes.setOnClickListener {

                textResultadoSwitch.text = "Switch clicado"

            }

            toggleAtivo.setOnClickListener {

                textResultadoSwitch.text = "Toggle clicado"

            }*/

            switchNotificacoes.setOnCheckedChangeListener { _, isChecked ->

                val resultado = if(isChecked) {
                    "Switch ativado"
                } else {
                    "Switch desativado"
                }

                textResultadoSwitch.text = "Valor Switch: $resultado"

            }

            toggleAtivo.setOnCheckedChangeListener { _, isChecked ->

                val resultado = if(isChecked) {
                    "Toggle ativado"
                } else {
                    "Toggle desativado"
                }

                textResultadoSwitch.text = "Valor Toggle: $resultado"

            }

        }

    }

    private fun switchToggle() {

        val switchMarcado = binding.switchNotificacoes.isChecked
        val toggleMarcado = binding.toggleAtivo.isChecked

        val texto = "Switch: $switchMarcado | Toggle: $toggleMarcado"
        binding.textResultadoSwitch.text = texto

    }
}