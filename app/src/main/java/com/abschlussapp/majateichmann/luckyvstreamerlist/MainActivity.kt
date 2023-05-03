package com.abschlussapp.majateichmann.luckyvstreamerlist

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.abschlussapp.majateichmann.luckyvstreamerlist.databinding.ActivityMainBinding

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        //todo: wenn api noch nicht komplett geladen, schalte appname+logo visibility auf gone(nicht sichtbar)
        //todo: wenn api fertig geladen (also screen 2 zu sehen) schalte appname+logo visibility auf visible (sichtbar)

        return super.onCreateView(name, context, attrs)
    }
}