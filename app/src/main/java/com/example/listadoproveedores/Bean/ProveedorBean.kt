package com.example.menucarta.bean

public class ProveedorBean {

    public enum class CAMPOS {
        Codigo,
        Ruc,
        RazonSocial,
        Direccion
    }

    var Codigo:Int=0
    var Ruc:String=""
    var RazonSocial:String =""
    var Direccion:String =""

    public constructor()
    {
        this.Codigo=0
        this.Ruc=""
        this.RazonSocial =""
        this.Direccion =""
    }


    constructor(pCodigo:Int, pRuc:String,pRazonSocial:String, pDireccion:String)
    {
        this.Codigo = pCodigo
        this.Ruc= pRuc
        this.RazonSocial = pRazonSocial
        this.Direccion = pDireccion
    }

}