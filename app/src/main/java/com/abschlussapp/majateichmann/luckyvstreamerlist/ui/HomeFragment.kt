package com.abschlussapp.majateichmann.luckyvstreamerlist.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.abschlussapp.majateichmann.luckyvstreamerlist.MainActivity
import com.abschlussapp.majateichmann.luckyvstreamerlist.R
import com.abschlussapp.majateichmann.luckyvstreamerlist.adapter.FilterAdapter
import com.abschlussapp.majateichmann.luckyvstreamerlist.adapter.LiveAdapter
import com.abschlussapp.majateichmann.luckyvstreamerlist.adapter.OfflineAdapter
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.StreamerList
import com.abschlussapp.majateichmann.luckyvstreamerlist.databinding.FragmentHomeBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class HomeFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MainViewModel by viewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentHomeBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        // Hier wird der Informationsabruf gestartet
        //todo: änderung 13:45
//        viewModel.loadData()
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val streamerListLive = binding.rvStreamerOnline
        val streamerListOffline = binding.rvStreamerOffline

        // Bei einem Klick auf btnRefresh sollen die Informationen erneut abgerufen werden
        binding.btnRefresh.setOnClickListener {
            viewModel.loadData()
            MainActivity().onApiLoading()
        }
        // Die Variable streamer wird beobachtet und bei einer Änderung wird der LiveAdapter der
        // Recyclerview neu gesetzt.
        viewModel.streamer.observe(
            viewLifecycleOwner
        ) {
            streamerListLive.adapter = LiveAdapter(it)
            streamerListOffline.adapter = OfflineAdapter(it)
//            binding.rvStreamerOnline.adapter = LiveAdapter(it)
//            binding.rvStreamerOffline.adapter = LiveAdapter(it)
        }

        // Verbesserte Performance bei fixer Listengröße
        binding.rvStreamerOnline.setHasFixedSize(true)
        binding.rvStreamerOffline.setHasFixedSize(true)
    }
}