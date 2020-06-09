package com.example.listadoproveedores.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadoproveedores.R
import com.example.menucarta.bean.ProveedorBean
import kotlinx.android.synthetic.main.registroproveedor.view.*

class AdaptadorProveedor(val ListaInterna:List<ProveedorBean>, val clickListener: (ProveedorBean) -> Unit ) :
    RecyclerView.Adapter<AdaptadorProveedor.ProveedorBeanHolder>() {

    var onItemClick: ((ProveedorBean)-> Unit)? = null

    public class ProveedorBeanHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oProveedorBean: ProveedorBean)
        {
            val tvCodigoProv = itemView.findViewById(R.id.tvITEMCODIGOPROVEEDOR) as TextView
            val tvRuc = itemView.findViewById(R.id.TVRUC_ITEM) as TextView
            val tvRazonSocial = itemView.findViewById(R.id.TVRAZONSOCIAL_ITEM) as TextView
            tvCodigoProv.text = oProveedorBean.Codigo.toString()
            tvRuc.text = oProveedorBean.Ruc
            tvRazonSocial.text = oProveedorBean.RazonSocial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorProveedor.ProveedorBeanHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.registroproveedor,parent,false)
        return ProveedorBeanHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaInterna.size
    }

    override fun onBindViewHolder(holder: ProveedorBeanHolder, position: Int) {
        holder?.itemView.tvITEMCODIGOPROVEEDOR?.text = ListaInterna.get(position).Codigo.toString()
        holder?.itemView.TVRUC_ITEM?.text = ListaInterna.get(position).Ruc
        holder?.itemView.TVRAZONSOCIAL_ITEM?.text = ListaInterna.get(position).RazonSocial
        holder?.itemView.setOnClickListener()
        {
                clickListener(ListaInterna.get(position))
        }
    }

inner class viewHolder(pVista:View): RecyclerView.ViewHolder(pVista), View.OnClickListener
{
    init {
        pVista.setOnClickListener()
        {
            onItemClick?.invoke(ListaInterna[adapterPosition])
        }
    }

    override fun onClick(v: View?) {
        onItemClick?.invoke(ListaInterna[adapterPosition])
    }
}


}