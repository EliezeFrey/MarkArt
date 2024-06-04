package com.eliezer.freyardaya.markart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giordanomatheus.cayusaucedo.markart.R
import com.giordanomatheus.cayusaucedo.markart.model.Producto

class ProductosAdapter(private var productos: List<Producto>) :
    RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto_simple, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    fun actualizarProductos(nuevaListaProductos: List<Producto>) {
        productos = nuevaListaProductos
        notifyDataSetChanged()
    }

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
        private val precioTextView: TextView = itemView.findViewById(R.id.precioTextView)

        fun bind(producto: Producto) {
            nombreTextView.text = producto.nombre_producto
            descripcionTextView.text = producto.descripcion_producto
            precioTextView.text = producto.precio_producto.toString()
            // Enlazar otros datos del producto según los campos que desees mostrar
        }
    }
}
