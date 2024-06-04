package com.giordanomatheus.cayusaucedo.markart.ui

import com.eliezer.freyardaya.markart.ProductosAdapter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giordanomatheus.cayusaucedo.markart.R
import com.com.eliezer.freyardaya.markart.io.RetrofitClient
import com.giordanomatheus.cayusaucedo.markart.model.Producto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuPrincipalActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: com.eliezer.freyardaya.markart.ProductosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        recyclerView = findViewById(R.id.recyclerProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = com.eliezer.freyardaya.markart.ProductosAdapter(emptyList())
        recyclerView.adapter = adapter

        obtenerListaProductos()

        // Inflar el layout activity_subir_producto.xml
        val inflater = layoutInflater
        val subirProductoLayout = inflater.inflate(R.layout.activity_subir_producto, null)

        // Encontrar el botón btnSubirProducto en el layout inflado
        val btnSubirProducto: Button = subirProductoLayout.findViewById(R.id.btnSubirProducto)
        btnSubirProducto.setOnClickListener {
            // Aquí puedes agregar la lógica para ir a la pantalla de subir producto
        }
    }

    private fun obtenerListaProductos() {
        RetrofitClient.checkApiConnection { isConnected ->
            if (isConnected) {
                val apiService = RetrofitClient.instance

                val callProductos = apiService.obtenerProductos()
                callProductos.enqueue(object : Callback<List<Producto>> {
                    override fun onResponse(call: Call<List<Producto>>, response: Response<List<Producto>>) {
                        if (response.isSuccessful) {
                            val productos = response.body()
                            productos?.let {
                                adapter.actualizarProductos(it)
                            }
                        } else {
                            // Manejar errores en la respuesta
                        }
                    }

                    override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                        // Manejar errores de conexión
                    }
                })
            } else {
                // Manejar falta de conexión
            }
        }
    }
}
