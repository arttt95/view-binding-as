package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.arttt95.aulaviewbinding.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButtonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFloatingActionButtonBinding.inflate(layoutInflater)
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

        inicializarToolbar()

        with(binding) {
            fabAdd.setOnClickListener {

                if(groupMenu.isVisible){
                    groupMenu.visibility = View.INVISIBLE
                } else {
                    groupMenu.visibility = View.VISIBLE
                }

            }
        }



    }

    private fun inicializarToolbar() {

        binding.tbMain.title = "YouTube"
//        binding.tbMain.subtitle = "Mais detalhes"
        binding.tbMain.setTitleTextColor(
            ContextCompat.getColor(this, R.color.md_theme_onPrimary)
        )
        binding.tbMain.setBackgroundColor(
            ContextCompat.getColor(this, R.color.md_theme_inversePrimary)
        )

        setSupportActionBar(binding.tbMain)

    }
}