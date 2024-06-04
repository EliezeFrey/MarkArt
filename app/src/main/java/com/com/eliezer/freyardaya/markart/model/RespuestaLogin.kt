package com.giordanomatheus.cayusaucedo.markart.model

data class RespuestaLogin(

    val token: String?, // Por ejemplo, el token JWT
    val mensaje: String // Otros datos que tu API devuelva en la respuesta de inicio de sesión
)
