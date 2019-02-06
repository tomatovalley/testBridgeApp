package com.jorgesoto.testbridge


import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_informacion_proyecto.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.json.JSONArray
import org.json.JSONObject


class Dashboard : AppCompatActivity() {

    var url = "https://reqres.in/api/unknown"


    val jsonObjs = JSONArray()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        textView.setText(UserModel.username)

        val que = Volley.newRequestQueue(this@Dashboard)

        val req = StringRequest(Request.Method.GET,url,
            Response.Listener<String> {
                    response ->

                    val gson = Gson()
                    val info = gson.fromJson(response, Info::class.java)

                tvIdProyecto?.text = info.page.toString()
                textView23?.text = info.data.get(0).name

            }, Response.ErrorListener {


                alert("Algo salio mal") {
                    title = "Alert"
                    yesButton { toast("No!!!") }
                    noButton { }
                }.show()
            })
        que.add(req)







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
