package com.com.eliezer.freyardaya.markart.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.markat.R
import com.giordanomatheus.cayusaucedo.markart.R
import com.giordanomatheus.cayusaucedo.markart.ui.InicioSesionActivity
import com.giordanomatheus.cayusaucedo.markart.ui.RegistroActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnInicioSesion = findViewById<Button>(R.id.btnInicioSesion)

        btnRegistro.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistroActivity::class.java)
            startActivity(intent)
        }

        btnInicioSesion.setOnClickListener {
            val intent = Intent(this@MainActivity, InicioSesionActivity::class.java)
            startActivity(intent)
        }
    }
}
