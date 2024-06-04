package com.giordanomatheus.cayusaucedo.markart.ui


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.giordanomatheus.cayusaucedo.markart.R
import com.com.eliezer.freyardaya.markart.io.RetrofitClient
import com.giordanomatheus.cayusaucedo.markart.model.RespuestaRegistro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnRegistro = findViewById<Button>(R.id.Registro)
        btnRegistro.setOnClickListener {
            try {
                val nombreEditText = findViewById<EditText>(R.id.name_edit_text)
                val emailEditText = findViewById<EditText>(R.id.email_edit_text)
                val passwordEditText = findViewById<EditText>(R.id.password_edit_text)

                val nombre = nombreEditText.text.toString()
                val email = emailEditText.text.toString()
                val contraseña = passwordEditText.text.toString()

                // Llama al método de registro en la API
                RetrofitClient.instance.register(nombre, email, contraseña)
                    .enqueue(object : Callback<RespuestaRegistro> {
                        override fun onResponse(
                            call: Call<RespuestaRegistro>,
                            response: Response<RespuestaRegistro>
                        ) {
                            if (response.isSuccessful) {
                                // Solicitud exitosa
                                Log.d("API", "Código de estado: ${response.code()}")
                                Toast.makeText(applicationContext, "Conectado a la API", Toast.LENGTH_SHORT).show()
                            } else {
                                // Manejar errores de solicitud
                                Log.e("API", "Error en la solicitud: ${response.code()}")
                                Toast.makeText(applicationContext, "Error en la solicitud: ${response.code()}", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<RespuestaRegistro>, t: Throwable) {
                            // Manejar errores de conexión
                            Log.e("API", "Error de conexión: ${t.message}")
                            Toast.makeText(applicationContext, "Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
                        }
                    })
            } catch (e: Exception) {
                e.printStackTrace()
                // Manejar la excepción aquí
                Log.e("API", "Excepción: ${e.message}")
                Toast.makeText(applicationContext, "Excepción: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}