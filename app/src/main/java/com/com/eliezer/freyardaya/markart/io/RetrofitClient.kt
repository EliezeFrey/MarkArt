package com.com.eliezer.freyardaya.markart.io

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.1.106:8000/api/"

    private fun createRetrofitInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val instance: Apiservice by lazy {
        createRetrofitInstance().create(Apiservice::class.java)
    }

    fun checkApiConnection(callback: (Boolean) -> Unit) {
        val apiService = instance

        // Realiza una petición a la API para comprobar la conexión
        apiService.testConnection().enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: retrofit2.Call<Void>, response: retrofit2.Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("RetrofitClient", "Conexión exitosa con la API")
                    callback(true) // Indica que la conexión es exitosa
                } else {
                    Log.e("RetrofitClient", "Error en la conexión con la API: ${response.code()}")
                    callback(false) // Indica que hubo un error en la conexión
                }
            }

            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                Log.e("RetrofitClient", "Error de conexión: ${t.message}")
                callback(false) // Indica que hubo un error en la conexión
            }
        })
    }
}
