package com.example.listadoproveedores.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadoproveedores.Bean.AlumnoBean
import com.example.listadoproveedores.R
import kotlinx.android.synthetic.main.registroalumno.view.*

class AdaptadorAlumno(var ListaInterna:List<AlumnoBean>, Contexto:Context)
    :RecyclerView.Adapter<AdaptadorAlumno.AlumnoBeanHolder>() {

    public class AlumnoBeanHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oAlumno:AlumnoBean)
        {
            var oTVdni=itemView.findViewById(R.id.TVITEM_ALUMNO_DNI) as TextView
            var oTVNombres=itemView.findViewById(R.id.TVITEM_ALUMNO_NOMBRES) as TextView
            var oTVCodigo=itemView.findViewById(R.id.TVITEM_ALUMNO_CODIGO) as TextView
            oTVdni.text = oAlumno.DNI
            oTVNombres.text = oAlumno.Nombres
            oTVCodigo.text = oAlumno.CodigoAlumuno.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoBeanHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.registroalumno,parent,false)
        return AdaptadorAlumno.AlumnoBeanHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaInterna.size
    }

    override fun onBindViewHolder(holder: AlumnoBeanHolder, position: Int) {
        holder?.itemView.TVITEM_ALUMNO_CODIGO?.text = ListaInterna.get(position).CodigoAlumuno.toString()
        holder?.itemView.TVITEM_ALUMNO_DNI?.text = ListaInterna.get(position).DNI
        holder?.itemView.TVITEM_ALUMNO_NOMBRES?.text = ListaInterna.get(position).Nombres
    }

}