package com.arttt95.aulaviewbinding

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arttt95.aulaviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var btnExecutar: Button
//    private lateinit var binding: ActivityMainBinding
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            btnExecutar?.setOnClickListener {
                Toast.makeText(btnExecutar.context, "Botão Executar", Toast.LENGTH_SHORT).show()
//                Toast.makeText(btnClicar?.context, "Botão Executar", Toast.LENGTH_SHORT).show()
            }

            btnClicar?.setOnClickListener {
                Toast.makeText(btnClicar.context, "Botão Clicar", Toast.LENGTH_SHORT).show()
            }
        }

        setContentView(binding.root)

        binding.btnExecutar.setOnClickListener {

        }

        /*btnExecutar = findViewById(R.id.btn_executar)

        btnExecutar.setOnClickListener {

        }*/

    }
}