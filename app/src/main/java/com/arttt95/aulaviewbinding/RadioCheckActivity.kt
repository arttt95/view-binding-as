package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivityRadioCheckBinding

class RadioCheckActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRadioCheckBinding.inflate(layoutInflater)
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

            btnEnviarRadio.setOnClickListener {

                radioButton()

            }

            /*rbMasculino.setOnClickListener{
                textResultadoRadio.text = "Masculino clicado"
            }

            rbFeminino.setOnClickListener {
                textResultadoRadio.text = "Feminino clicado"
            }*/

            /*rbMasculino.setOnCheckedChangeListener { _, isChecked ->
                textResultadoRadio.text = "Masculino clicado"
            }*/

        }

    }

    private fun radioButton() {

        /*val selecionadoMasculino = binding.rbMasculino.isChecked
        val selecionadoFeminino = binding.rbFeminino.isChecked*/

//        binding.rgSexo.clearCheck()
        val itemSelecionado = binding.rgSexo.checkedRadioButtonId

        /*if(selecionadoMasculino) {
            binding.textResultadoRadio.text = "Masculino"
        } else if (selecionadoFeminino) {
            binding.textResultadoRadio.text = "Feminino"
        } else {
            Toast.makeText(this, "Preencha os campos de sexo", Toast.LENGTH_LONG).show()
        }*/

        binding.textResultadoRadio.text = when(itemSelecionado) {
            R.id.rbMasculino -> "Masculino"
            R.id.rbFeminino -> "Feminino"
            else -> "Nada selecioonado"
        }

        binding.rgSexo.clearCheck()


    }

}