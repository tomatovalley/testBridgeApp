package com.jorgesoto.testbridge


import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_informacion_proyecto.view.*



class InformacionProyectoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_informacion_proyecto, container, false)
        //Por medio del value view podemos acceder a los elementos/vistas del fragmento
        view.btnAceptarProyecto.setOnClickListener {
            //AGREGAR QUE CAMBIE DE FRAGMENT DINAMICAMENTE
            
        }
        return view
    }


}
