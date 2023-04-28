package com.abschlussapp.majateichmann.luckyvstreamerlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.abschlussapp.majateichmann.luckyvstreamerlist.R
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer
import com.abschlussapp.majateichmann.luckyvstreamerlist.databinding.FragmentHomeBinding

/
/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MainViewModel by viewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hier wird der Informationsabruf gestartet
        viewModel.loadData()

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bei einem Klick auf btnRefresh sollen die Informationen erneut abgerufen werden
        binding.btnRefresh.setOnClickListener {
            viewModel.loadData()
        }

        // Verbesserte Performance bei fixer Listengröße
        binding.rvStreamer.setHasFixedSize(true)

        // Die Variable streamer wird beobachtet und bei einer Änderung wird der Adapter der
        // Recyclerview neu gesetzt.
        viewModel.streamer.observe(
            viewLifecycleOwner
        ) {
            binding.rvStreamer.adapter = Adapter(it, viewModel)
        }
    }
}