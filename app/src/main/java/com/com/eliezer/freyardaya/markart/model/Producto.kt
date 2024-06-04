package com.giordanomatheus.cayusaucedo.markart.model

data class Producto(

val nombre_producto: String,
val descripcion_producto: String,
val precio_producto: Double,
val cantidad_producto: Int,
val id_categoria: Int,
val id_usuario: Int,
val foto_de_producto: String // Suponiendo que es una URL de la foto
)

