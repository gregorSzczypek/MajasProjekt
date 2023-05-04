package com.abschlussapp.majateichmann.luckyvstreamerlist.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abschlussapp.majateichmann.luckyvstreamerlist.R
import com.abschlussapp.majateichmann.luckyvstreamerlist.adapter.LiveAdapter
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.remote.StreamerApi
import kotlinx.coroutines.launch

//class StartFragment : Fragment() {
//    //Progressbar implementieren
//    private lateinit var progressBar: ProgressBar
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_start, container, false)
//        progressBar = view.findViewById(R.id.progressBar)
//        return view
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        loadData()
//    }
//
//    private fun loadData() {
//        GlobalScope.launch(Dispatchers.IO) {
//            val streamers = StreamerApi
//            // process streamers data here
//        }
//    }
//
//    private fun updateProgress(bytesRead: Int, contentLength: Int) {
//        if (contentLength == -1) {
//            progressBar.isIndeterminate = true
//        } else {
//            val percent = (bytesRead.toDouble() / contentLength.toDouble()) * 100
//            progressBar.progress = percent.toInt()
//        }
//    }
//}

class StartFragment : Fragment() {

    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Coroutine starten, um die Streamer-Daten von der API abzurufen
        lifecycleScope.launch {
            progressBar.visibility = View.VISIBLE
            try {
                // Die "getStreamers()" Funktion wird asynchron aufgerufen und das Ergebnis wird in "streamers" gespeichert.
                val streamers = StreamerApi.retrofitService.getStreamers()

                // Wenn der Abruf erfolgreich war, wird der Fortschrittsbalken ausgeblendet.
                //todo
//                progressBar.visibility = View.GONE

                // TODO: Verarbeite die "streamers" Daten
//                val recyclerViewLive: RecyclerView = view.findViewById(R.id.rv_streamer_online)
//                recyclerViewLive.adapter = LiveAdapter(streamers.streamer)
//                val recyclerViewOffline: RecyclerView = view.findViewById(R.id.rv_Streamer_offline)
//                recyclerViewOffline.adapter = LiveAdapter(streamers.streamer)

                val recyclerViewLive: RecyclerView? = view.findViewById(R.id.rv_streamer_online)
                recyclerViewLive?.adapter = LiveAdapter(streamers.streamer)
                val recyclerViewOffline: RecyclerView? = view.findViewById(R.id.rv_Streamer_offline)
                recyclerViewOffline?.adapter = LiveAdapter(streamers.streamer)

                //TODO: navigation von startfragment zu homefragment
                val navController = view.findNavController()
                if(progressBar.visibility == View.GONE){
//                    val navController = view.findNavController()
                    navController.navigate(R.id.action_startFragment_to_homeFragment)
                }
            } catch (e: Exception) {
                // Wenn ein Fehler aufgetreten ist, wird der Fortschrittsbalken ausgeblendet und eine Fehlermeldung angezeigt.
                progressBar.visibility = View.GONE

                // Zeige einen Fehler-Dialog oder eine Fehlermeldung an.
                Log.e(TAG,"Changing visibility of progressbar failed: $e")
            }
        }
    }
}