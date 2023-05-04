package com.abschlussapp.majateichmann.luckyvstreamerlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abschlussapp.majateichmann.luckyvstreamerlist.databinding.ActivityMainBinding

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //apiLoading auf true setzen -> Progressbar noch sichtbar
    private var apiLoading: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    //Wenn API noch nicht geladen: Header nicht sichtbar
    if(apiLoading) {
        binding.clAppHeader.visibility = View.GONE
    }else
    {
        //Header wird angezeigt, wenn Api fertig geladen
        binding.clAppHeader.visibility = View.VISIBLE
    }
}
    fun onApiLoading(){
        //ApiLoading wird auf false gesetzt, wenn api fertig geladen
        apiLoading = false
        //Header wird angezeigt, wenn Api fertig geladen
        binding.clAppHeader.visibility = View.VISIBLE

        //todo: Navigiere zu HomeFragment
//        findNavController(View).navigate(R.id.action_startFragment_to_homeFragment)

    }
}