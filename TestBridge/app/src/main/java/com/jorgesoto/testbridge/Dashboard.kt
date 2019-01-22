package com.jorgesoto.testbridge


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.fragment_informacion_proyecto.*


class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnAceptarProyecto.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragmentoNuevo = RegistroBugFragmento()
            fragmentTransaction.replace(R.id.contenedorFragmento,fragmentoNuevo)
            fragmentTransaction.setTransition()
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}
