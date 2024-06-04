package com.com.eliezer.freyardaya.markart.io

import com.giordanomatheus.cayusaucedo.markart.model.Producto
import com.giordanomatheus.cayusaucedo.markart.model.RespuestaLogin
import com.giordanomatheus.cayusaucedo.markart.model.RespuestaRegistro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface Apiservice {

    @GET("test") // Endpoint de prueba en tu API
    fun testConnection(): Call<Void>


                @FormUrlEncoded
                @POST("register") // Ruta de registro en tu API
                fun register(
                        @Field("name") name: String,
                        @Field("email") email: String,
                        @Field("password") password: String
                ): Call<RespuestaRegistro>

                @FormUrlEncoded
                @POST("login") // Ruta de inicio de sesión en tu API
                fun login(
                        @Field("email") email: String,
                        @Field("password") password: String
                ): Call<RespuestaLogin>

    @GET("productions") // Esto puede variar según tus rutas en la API
    fun obtenerProductos(): Call<List<Producto>>

    @GET("productos/{id}")
    fun obtenerProductoPorId(@Path("id") id: Int): Call<Producto>

    @POST("productos")
    fun subirProducto(@Body producto: Producto): Call<Producto>

    @PUT("productos/{id}")
    fun actualizarProducto(@Path("id") id: Int, @Body producto: Producto): Call<Producto>

    @DELETE("productos/{id}")
    fun eliminarProducto(@Path("id") id: Int): Call<Void>
}

