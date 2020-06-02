package com.example.listadoproveedores.data

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.menucarta.bean.ProveedorBean

class ProveedorDAL: ClaseBase() {
    val NOMBRE_TABLA="Proveedor"
    init
    {
        super.CrearBaseDatos()
    }
//pAccion = N -->Es un registro nuevo se debe insertar
//pAccion = A -->Es un registro existe se debe actualizar
public fun RegistraModifica(pProv:ProveedorBean, pAccion:String)
   {
       var odb:SQLiteDatabase= SQLiteDatabase.openDatabase(this.CadenaConexion(), null,
       SQLiteDatabase.CREATE_IF_NECESSARY)

       var oRegistro:ContentValues= ContentValues()
       oRegistro.put("Codigo",pProv.Codigo)
       oRegistro.put("Ruc",pProv.Ruc)
       oRegistro.put("RazonSocial",pProv.RazonSocial)
       oRegistro.put("Direccion",pProv.Direccion)
       if (pAccion =="N") {
           var oresult = odb.insert(NOMBRE_TABLA, null, oRegistro).toInt()
           if (oresult == -1) {
            //Error de insert
           }
       }
else if (pAccion =="A") {

           var oresult = odb.update(
               NOMBRE_TABLA,
               oRegistro,
               " Codigo = " + pProv.Codigo.toString(),
               null ).toInt()
           if (oresult == -1) {
            //Error de update
           }
       }
       odb.close()
   }

    public fun Lista(pProv:ProveedorBean): ArrayList<ProveedorBean>
    {
        var oLista=ArrayList<ProveedorBean>()
        var odb:SQLiteDatabase= SQLiteDatabase.openDatabase(this.CadenaConexion(), null,
            SQLiteDatabase.CREATE_IF_NECESSARY)
        var oTabla: Cursor=odb.rawQuery("Select * from " + NOMBRE_TABLA, null)
        if (oTabla.moveToFirst())
        {
            do {
                oLista.add(
                    ProveedorBean(
                        oTabla.getInt(0), //Codigo
                        oTabla.getString(1), //Ruc
                        oTabla.getString(2), //Razon Social
                        oTabla.getString(3) //Dirección
                        )
                )
            } while (oTabla.moveToNext())
        }
        return oLista
    }

}