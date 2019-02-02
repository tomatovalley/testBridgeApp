package com.jorgesoto.testbridge


import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.fragment_informacion_proyecto.*


class Dashboard : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //JSON DEL PROYECTO
        var jsonTester = "{ \"Users\" : [ " +
                "{" +
                " \"username\" : \"root\" ," +
                " \"password\" : \"pass1234\" ," +
                " \"user_type\" : \"TESTER\" ," +
                " \"projectos\" : [ "+
                "{"+
                " \"project_id\" : \"1\"," +
                " \"project\" : \"Testbridge\"," +
                " \"type\" : \"MOBILE\"," +
                " \"type\" : \"MOBILE\"," +
                ""+"]"+"}" +

                "{" +
                " \"nombre\" : \"Agustín\" ," +
                " \"pais\" : \"España\" ," +
                " \"estado\" : \"casado\" ," +
                " \"experiencia\" : 16}" +
                " ]" +
                " }"



        textView.setText(UserModel.username)


        btnAceptarProyecto.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragmentoNuevo = RegistroBugFragmento()
            fragmentTransaction.replace(R.id.contenedorFragmento,fragmentoNuevo)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}
