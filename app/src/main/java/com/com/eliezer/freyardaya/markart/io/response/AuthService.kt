package com.com.eliezer.freyardaya.markart.io.response

import com.com.eliezer.freyardaya.markart.io.Apiservice
import com.giordanomatheus.cayusaucedo.markart.model.RespuestaRegistro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService(private val Apiservice: Apiservice) {

        fun registrarUsuario(nombre: String, email: String, contraseña: String, callback: (Boolean, String) -> Unit) {
            Apiservice.register(nombre, email, contraseña)
                .enqueue(object : Callback<RespuestaRegistro> {
                    override fun onResponse(call: Call<RespuestaRegistro>, response: Response<RespuestaRegistro>) {
                        if (response.isSuccessful) {
                            callback(true, "Usuario registrado exitosamente")
                        } else {
                            callback(false, "Error al registrar usuario")
                        }
                    }

                    override fun onFailure(call: Call<RespuestaRegistro>, t: Throwable) {
                        callback(false, "Error de conexión")
                    }
                })
        }

        // Método similar para iniciar sesión, usando apiService.login()
    }
