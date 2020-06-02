package com.example.listadoproveedores.Actividad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listadoproveedores.Adaptador.AdaptadorAlumno
import com.example.listadoproveedores.Bean.AlumnoBean
import com.example.listadoproveedores.R
import kotlinx.android.synthetic.main.activity_lista_alumno_grid_view.*


class ListaAlumnoGridView : AppCompatActivity() {

    lateinit var oListaAlumnos:ArrayList<AlumnoBean>
    lateinit var oAdaptadorAlumno:AdaptadorAlumno

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alumno_grid_view)

        oListaAlumnos =ArrayList<AlumnoBean>()
        oListaAlumnos.add(AlumnoBean("Santiago","324234234"))
        oListaAlumnos.add(AlumnoBean("Maria","324234"))
        oListaAlumnos.add(AlumnoBean("Hellen","324234234"))
        oListaAlumnos.add(AlumnoBean("Betzi","324234"))

        oListaAlumnos.add(AlumnoBean("Santiago","324234234"))
        oListaAlumnos.add(AlumnoBean("Maria","324234"))
        oListaAlumnos.add(AlumnoBean("Hellen","324234234"))
        oListaAlumnos.add(AlumnoBean("Betzi","324234"))
        oListaAlumnos.add(AlumnoBean("Santiago","324234234"))
        oListaAlumnos.add(AlumnoBean("Maria","324234"))
        oListaAlumnos.add(AlumnoBean("Hellen","324234234"))
        oListaAlumnos.add(AlumnoBean("Betzi","324234"))


        oAdaptadorAlumno = AdaptadorAlumno(oListaAlumnos, this)
        rvAlumnosGridView.setLayoutManager(GridLayoutManager(this, 4))
        rvAlumnosGridView.setAdapter( oAdaptadorAlumno)
    }
}
