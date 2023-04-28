package com.abschlussapp.majateichmann.luckyvstreamerlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.abschlussapp.majateichmann.luckyvstreamerlist.R
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.remote.StreamerApi


/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)

//        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
//
//// Aktivieren Sie die ProgressBar
//        progressBar.visibility = View.VISIBLE
//
//// Führen Sie den API-Aufruf aus
//        StreamerApi.execute(object : Callback {
//            override fun onSuccess(result: ApiResponse) {
//                // Aktualisieren Sie die ProgressBar
//                progressBar.progress = 100
//
//                // Verstecken Sie die ProgressBar
//                progressBar.visibility = View.GONE
//            }
//
//            override fun onError(error: String) {
//                // Verstecken Sie die ProgressBar
//                progressBar.visibility = View.GONE
//            }
//        }
//        )

    }
}