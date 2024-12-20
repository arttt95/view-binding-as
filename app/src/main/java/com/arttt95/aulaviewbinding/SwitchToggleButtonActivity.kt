package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivitySwitchToggleButtonBinding
import com.google.android.material.snackbar.Snackbar

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

            btnEnviarSwitch.setOnClickListener { view ->

                switchToggle()
//                exibirSnackBar()

                /*val snackbar = Snackbar.make(
                    view,
                    "Alteração realizada com sucesso!",
                    Snackbar.LENGTH_LONG
                )

                snackbar.setAction("Desfazer") {
                    Toast.makeText(
                        this@SwitchToggleButtonActivity,
                        "Desfeito",
                        Toast.LENGTH_LONG).show()
                }

                snackbar.setTextColor(
                    ContextCompat.getColor(
                        this@SwitchToggleButtonActivity,
                        R.color.md_theme_onPrimary
                    )
                )

                snackbar.setActionTextColor(
                    ContextCompat.getColor(
                        this@SwitchToggleButtonActivity,
                        R.color.md_theme_error_highContrast
                    )
                )

                snackbar.setBackgroundTint(
                    ContextCompat.getColor(
                        this@SwitchToggleButtonActivity,
                        R.color.md_theme_inversePrimary
                    )
                )

                snackbar.show()*/

            }

            /*switchNotificacoes.setOnClickListener {

                textResultadoSwitch.text = "Switch clicado"

            }*/

            /*toggleAtivo.setOnClickListener {

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

//    private fun exibirSnackBar() {
//
//        Toast.makeText(this, "Mensagem", Toast.LENGTH_SHORT).show()
//
//
//
//    }

    private fun switchToggle() {

        val switchMarcado = binding.switchNotificacoes.isChecked
        val toggleMarcado = binding.toggleAtivo.isChecked

        val texto = "Switch: $switchMarcado | Toggle: $toggleMarcado"
        binding.textResultadoSwitch.text = texto

    }
}