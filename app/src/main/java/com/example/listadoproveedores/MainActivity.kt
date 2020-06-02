package com.example.listadoproveedores

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoproveedores.Actividad.ListaAlumnoGridView
import com.example.listadoproveedores.Actividad.ListadoAlumno
import com.example.listadoproveedores.Adaptador.AdaptadorProveedor
import com.example.listadoproveedores.Tools.Constantes
import com.example.listadoproveedores.data.ProveedorDAL
import com.example.menucarta.bean.ProveedorBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var oListaproveedor:ArrayList<ProveedorBean>
    lateinit var oAdaptadorProveedor: AdaptadorProveedor
    lateinit var oNuevoPRoveedor: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oListaproveedor= ArrayList<ProveedorBean>()
       /* oListaproveedor.add(ProveedorBean(1,"1041009882","Cibertec SAC",
            "Av Izaguirre"))
        oListaproveedor.add(ProveedorBean(2,"3453453454","MEtro SAC",
            "Av Izaguirre"))
*/
        var oProveedorDAL:ProveedorDAL= ProveedorDAL()
        oListaproveedor=oProveedorDAL.Lista(ProveedorBean())
        oAdaptadorProveedor= AdaptadorProveedor(oListaproveedor.toList(), this)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        lvListaProveedor.setLayoutManager(llm)
        lvListaProveedor.setHasFixedSize(true)
        lvListaProveedor.setAdapter(oAdaptadorProveedor)


        fbListaGridView.setOnClickListener()
        {
            val olista:Intent= Intent(this,ListaAlumnoGridView::class.java)
            startActivity(olista)
        }
    }

    public fun btnCargarDialogo_onclick(v: View)
    {
        oNuevoPRoveedor = Dialog(this)
        oNuevoPRoveedor.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoPRoveedor.setCancelable(false)
        oNuevoPRoveedor.setContentView(R.layout.nuevoproveedoractivity)
        val obtnagregarNuevoprov = oNuevoPRoveedor.findViewById(R.id.btnagregarNuevoprov) as Button
        val obtnCancelarNuevoprov = oNuevoPRoveedor.findViewById(R.id.btnCancelarNuevoprov) as Button
        obtnagregarNuevoprov.setOnClickListener {
            GrabarRegistro()
            oNuevoPRoveedor.dismiss() }
        obtnCancelarNuevoprov.setOnClickListener { oNuevoPRoveedor.dismiss() }
        oNuevoPRoveedor.show()
    }

    private fun GrabarRegistro()
    {        var oedtrucnuevo:EditText= (oNuevoPRoveedor.findViewById(R.id.edtrucnuevo) as EditText)
        var oedtdireccionnuevo:EditText= (oNuevoPRoveedor.findViewById(R.id.edtdireccionnuevo) as EditText)
        var oedtrazonsocialnuevo:EditText= (oNuevoPRoveedor.findViewById(R.id.edtrazonsocialnuevo) as EditText)
        var oProveedorBean:ProveedorBean=ProveedorBean(oListaproveedor.size,
        oedtrucnuevo.text.toString(),
        oedtrazonsocialnuevo.text.toString(),
        oedtdireccionnuevo.text.toString() )

        var oProveedorDAL:ProveedorDAL=ProveedorDAL()
        oProveedorDAL.RegistraModifica(oProveedorBean, Constantes.NUEVO_REGISTRO)
        oListaproveedor.add(oProveedorBean)

        oAdaptadorProveedor= AdaptadorProveedor(oListaproveedor.toList(), this)
        lvListaProveedor.setAdapter(oAdaptadorProveedor)
    }

    public fun btnNuevoAlumno_onclick(v:View)
    {
        var oalumnoIntent:Intent= Intent(this, ListadoAlumno::class.java)
        startActivity(oalumnoIntent)
    }
}
