package com.jorgesoto.testbridge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registro_dispositivo.*
import org.json.JSONObject

class RegistroDispositivo : AppCompatActivity() {


    var url = "http://178.128.152.204:8080/api-devices/devices/"

    val jsonObjs = JSONObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_dispositivo)

        btnRegistrarDispositivo.setOnClickListener {

        }
    }
}
