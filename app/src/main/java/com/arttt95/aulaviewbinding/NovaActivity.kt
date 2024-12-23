package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivityNovaBinding

class NovaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNovaBinding.inflate(layoutInflater)
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
        }

        inicializarToolbar()

    }

    private fun inicializarToolbar() {

        // BOTÃO DE VOLTAR
        binding.includeToolbar.clLogo.visibility = View.GONE
        binding.includeToolbar.tbMain.title = "Nova"

        setSupportActionBar(binding.includeToolbar.tbMain)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        inicializarActionbar()

    }

    private fun inicializarActionbar() {
        addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_principal, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when(menuItem.itemId) {
                        R.id.item_adicionar -> {
                            Toast.makeText(applicationContext, "Adicionar clicado", Toast.LENGTH_LONG).show()
                        }
                        R.id.item_pesquisar -> {
                            Toast.makeText(applicationContext, "Pesquisar clicado", Toast.LENGTH_LONG).show()
                        }
                        R.id.item_configuracoes -> {
                            Toast.makeText(applicationContext, "Configurações clicado", Toast.LENGTH_LONG).show()
                        }
                        R.id.item_sair -> {
                            Toast.makeText(applicationContext, "Sair clicado", Toast.LENGTH_LONG).show()
                        }

                    }

                    return true
                }

            }
        )
    }
}