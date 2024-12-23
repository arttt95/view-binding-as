package com.arttt95.aulaviewbinding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivityToolbarActionbarBinding

class ToolbarActionbarActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityToolbarActionbarBinding.inflate(layoutInflater)
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

//        supportActionBar?.hide()

        val intent = Intent(this, FloatingActionButtonActivity::class.java)

        inicializarToolbar()

        with(binding) {

            btnOutraPagina.setOnClickListener {

                startActivity(intent)

            }

        }

    }

    private fun inicializarToolbar() {

        binding.includeToolbar.tbMain.title = "YouTube"
//        binding.includeToolbar.tbMain.subtitle = "Mais detalhes"
        binding.includeToolbar.tbMain.setTitleTextColor(
            ContextCompat.getColor(this, R.color.md_theme_onPrimary)
        )
        binding.includeToolbar.tbMain.setBackgroundColor(
            ContextCompat.getColor(this, R.color.md_theme_inversePrimary)
        )

        binding.includeToolbar.tbMain.inflateMenu(R.menu.menu_principal)

        binding.includeToolbar.tbMain.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.item_adicionar -> {
                    Toast.makeText(applicationContext, "Adicionar clicado", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_pesquisar -> {
                    Toast.makeText(applicationContext, "Pesquisar clicado", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_configuracoes -> {
                    Toast.makeText(applicationContext, "Configurações clicado", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_sair -> {
                    Toast.makeText(applicationContext, "Sair clicado", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                else -> return@setOnMenuItemClickListener true

            }

            /*when(menuItem.itemId) {
                R.id.item_adicionar -> {
                    Toast.makeText(applicationContext, "Adicionar clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_pesquisar -> {
                    Toast.makeText(applicationContext, "Pesquisar clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_configuracoes -> {
                    Toast.makeText(applicationContext, "Configurações clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_sair -> {
                    Toast.makeText(applicationContext, "Sair clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true

            }*/
        }

//        setSupportActionBar(binding.includeToolbar.tbMain)
//        inicializarActionbar()

    }

    /*private fun inicializarActionbar() {
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
    }*/

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_principal, menu)

        return true
//        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.item_adicionar -> {
                Toast.makeText(this, "Adicionar clicado", Toast.LENGTH_SHORT).show()
            }
            R.id.item_pesquisar -> {
                Toast.makeText(this, "Pesquisar clicado", Toast.LENGTH_SHORT).show()
            }
            R.id.item_configuracoes -> {
                Toast.makeText(this, "Configurações clicado", Toast.LENGTH_SHORT).show()
            }
            R.id.item_sair -> {
                Toast.makeText(this, "Sair clicado", Toast.LENGTH_SHORT).show()
            }

        }

        return true
//        return super.onOptionsItemSelected(item)
    }*/
}