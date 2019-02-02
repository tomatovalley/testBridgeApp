package com.jorgesoto.testbridge

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.json.JSONObject



class Login : AppCompatActivity() {

    var url = "https://reqres.in/api/login"

    val jsonObjs = JSONObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar.setOnClickListener {


            jsonObjs.put("email", etUsuario.text.toString())
            jsonObjs.put("password", etContrasena.text.toString())

            val que = Volley.newRequestQueue(this@Login)
            val req = JsonObjectRequest(Request.Method.POST,url,jsonObjs,
                Response.Listener {
                    response ->

                    // Credenciales para test

                    //   "email": "peter@klaven",
                    //    "password": "cityslicka"

                    // Guardar el usuario
                    UserModel.username = etUsuario.text.toString()

                    var i = Intent(this, Dashboard::class.java)
                    startActivity(i)


                }, Response.ErrorListener {


                    alert("Algo salio mal") {
                        title = "Alert"
                        yesButton { toast("No!!!") }
                        noButton { }
                    }.show()
                })
            que.add(req)
        }
    }
}
