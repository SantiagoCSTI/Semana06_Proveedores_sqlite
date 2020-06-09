package com.example.listadoproveedores.Actividad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoproveedores.Adaptador.AdaptadorAlumno
import com.example.listadoproveedores.Bean.AlumnoBean
import com.example.listadoproveedores.R
import kotlinx.android.synthetic.main.activity_listado_alumno.*
import kotlinx.android.synthetic.main.activity_main.*

class ListadoAlumno : AppCompatActivity() {
lateinit var oListaAlumnos:ArrayList<AlumnoBean>
    lateinit var oAdaptadorAlumno:AdaptadorAlumno

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_alumno)

        oListaAlumnos = ArrayList<AlumnoBean>()
        oListaAlumnos.add(AlumnoBean("Santiago Solis","414141413"))
        oListaAlumnos.add(AlumnoBean("Juan Jose Solis","43534535"))

        oAdaptadorAlumno= AdaptadorAlumno(oListaAlumnos,this)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvListadoAlumnos.setLayoutManager(llm)
        rvListadoAlumnos.setHasFixedSize(true)


        rvListadoAlumnos.setAdapter(oAdaptadorAlumno)
    }
}
