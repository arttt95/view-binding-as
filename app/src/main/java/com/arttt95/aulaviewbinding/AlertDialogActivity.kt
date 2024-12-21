package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAlertDialogBinding.inflate(layoutInflater)
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

            btnEnviarAlert.setOnClickListener {
                caixaDialogoAlerta()
            }

        }

    }

    private fun caixaDialogoAlerta() {

        AlertDialog.Builder(this)
            .setTitle("Confirmar exclusão do item")
            .setMessage("Tem certeza que deseja remover?")
            .setNegativeButton("Cancelar"){ /*dialog*/_, position ->

                Toast.makeText(this, "Cancelar posição: ($position)", Toast.LENGTH_LONG).show()
//            dialog.dismiss()
            }
            .setPositiveButton("Confirmar") { /*dialog*/_, position ->

                Toast.makeText(this, "Confirmar posição: ($position)", Toast.LENGTH_LONG).show()
//            dialog.dismiss()
            }
            .setCancelable(false)
            .create()
            .show()

        /*val alertBuilder = AlertDialog.Builder(this)

        alertBuilder.setTitle("Confirmar exclusão do item")
        alertBuilder.setMessage("Tem certeza que deseja remover?")
        alertBuilder.setNegativeButton("Cancelar") { *//*dialog*//*_, position ->

            Toast.makeText(this, "Cancelar posição: ($position)", Toast.LENGTH_LONG).show()
//            dialog.dismiss()
        }
        alertBuilder.setPositiveButton("Confirmar") { *//*dialog*//*_, position ->

            Toast.makeText(this, "Confirmar posição: ($position)", Toast.LENGTH_LONG).show()
//            dialog.dismiss()
        }

        alertBuilder.setCancelable(false)
        alertBuilder.setNeutralButton("Ajuda"){_, position ->
            Toast.makeText(this, "Ajuda posição($position)", Toast.LENGTH_SHORT).show()
        }
        alertBuilder.setIcon(R.drawable.ic_alert_24)

        val alertDialog = alertBuilder.create()
        alertDialog.show()*/

    }
}