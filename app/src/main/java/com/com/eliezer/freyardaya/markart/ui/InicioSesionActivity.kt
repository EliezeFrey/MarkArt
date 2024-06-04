package com.giordanomatheus.cayusaucedo.markart.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.giordanomatheus.cayusaucedo.markart.R
import com.com.eliezer.freyardaya.markart.io.RetrofitClient
import com.giordanomatheus.cayusaucedo.markart.model.RespuestaLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InicioSesionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnInicioSesion = findViewById<Button>(R.id.InicioSesion)
        btnInicioSesion.setOnClickListener {
            try {
                val emailEditText = findViewById<EditText>(R.id.et_email)
                val passwordEditText = findViewById<EditText>(R.id.et_password)

                val email = emailEditText.text.toString()
                val contraseña = passwordEditText.text.toString()

                // Llama al método de inicio de sesión en la API
                RetrofitClient.instance.login(email, contraseña)
                    .enqueue(object : Callback<RespuestaLogin> {
                        override fun onResponse(
                            call: Call<RespuestaLogin>,
                            response: Response<RespuestaLogin>
                        ) {
                            if (response.isSuccessful) {
                                val respuestaLogin = response.body()

                                // Verifica si la respuesta contiene datos relevantes
                                if (respuestaLogin != null) {
                                    val token = respuestaLogin.token
                                    // Aquí podrías almacenar el token o realizar otras acciones según tu lógica de sesión
                                    // Por ejemplo, mostrar un mensaje de inicio de sesión exitoso:
                                    runOnUiThread {
                                        Toast.makeText(
                                            applicationContext,
                                            "Inicio de sesión exitoso",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        // Lleva al usuario a la actividad del menú principal
                                        val intent = Intent(this@InicioSesionActivity, MenuPrincipalActivity::class.java)
                                        startActivity(intent)
                                        finish() // Finaliza la actividad actual para que no se pueda volver atrás desde el menú principal
                                    }
                                }
                            } else {
                                // Manejar errores de inicio de sesión
                                // Por ejemplo, si el inicio de sesión falla debido a credenciales incorrectas,
                                // podrías mostrar un mensaje de error.
                                runOnUiThread {
                                    Toast.makeText(
                                        applicationContext,
                                        "Error: Inicio de sesión fallido",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<RespuestaLogin>, t: Throwable) {
                            // Manejar errores de conexión
                            runOnUiThread {
                                Toast.makeText(
                                    applicationContext,
                                    "Error de conexión: ${t.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
            } catch (e: Exception) {
                e.printStackTrace()
                // Manejar la excepción aquí
            }
        }
    }
}
