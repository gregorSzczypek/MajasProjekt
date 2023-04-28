package com.abschlussapp.majateichmann.luckyvstreamerlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abschlussapp.majateichmann.luckyvstreamerlist.adapter.Adapter

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}