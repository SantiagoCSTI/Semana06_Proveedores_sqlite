package com.example.listadoproveedores.data

import android.database.sqlite.SQLiteDatabase

open class ClaseBase {

    public fun CadenaConexion():String
    {
        return "/data/data/com.example.listadoproveedores/proveedor.db"
    }

    public fun CrearBaseDatos()
    {
        var odb:SQLiteDatabase= SQLiteDatabase.openDatabase(
            CadenaConexion(),
            null,
            SQLiteDatabase.CREATE_IF_NECESSARY)
        odb.execSQL("CREATE TABLE IF NOT EXISTS Proveedor(Codigo int, Ruc varchar(11), " +
                "RazonSocial varchar(250)," +
                "Direccion varchar(500) )")

    }
}