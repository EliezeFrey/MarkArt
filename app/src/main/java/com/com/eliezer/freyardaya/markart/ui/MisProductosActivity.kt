package com.giordanomatheus.cayusaucedo.markart.ui

import com.eliezer.freyardaya.markart.ProductosAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giordanomatheus.cayusaucedo.markart.R
import com.giordanomatheus.cayusaucedo.markart.model.Producto


class MisProductosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: com.eliezer.freyardaya.markart.ProductosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        recyclerView = findViewById(R.id.recyclerProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listaProductos: List<Producto> = obtenerListaProductosDesdeApi()

        adapter = com.eliezer.freyardaya.markart.ProductosAdapter(listaProductos)
        recyclerView.adapter = adapter
    }

    private fun obtenerListaProductosDesdeApi(): List<Producto> {
        return listOf(
            Producto(
                "Producto 1",
                "Descripción 1",
                10.0,
                5,
                1,
                1,
                "url_foto_producto_1"
            ),
            Producto(
                "Producto 2",
                "Descripción 2",
                20.0,
                10,
                2,
                1,
                "url_foto_producto_2"
            ),
            Producto(
                "Producto 3",
                "Descripción 3",
                30.0,
                7,
                3,
                2,
                "url_foto_producto_3"
            )
            // Agregar más productos según sea necesario
        )
    }
}
