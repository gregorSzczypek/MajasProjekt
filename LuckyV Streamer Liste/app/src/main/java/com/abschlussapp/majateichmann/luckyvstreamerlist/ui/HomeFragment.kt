package com.abschlussapp.majateichmann.luckyvstreamerlist.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.viewModels
import androidx.room.Query
import com.abschlussapp.majateichmann.luckyvstreamerlist.R
import com.abschlussapp.majateichmann.luckyvstreamerlist.adapter.Adapter
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.StreamerList
import com.abschlussapp.majateichmann.luckyvstreamerlist.databinding.FragmentHomeBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

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
            binding.rvStreamer.adapter = Adapter(context,StreamerList)
        }

        val streamerList = listOf("Deutschland", "Österreich", "Schweiz", "USA", "Kanada", "Frankreich")
        val adapter = Adapter(requireContext(), streamerList)
        binding.tvAutocompleteSearch.setAdapter(adapter)

        val filterButton = view.findViewById<Button>(R.id.filter_button)
        filterButton.setOnClickListener {
            showFilterDialog()
        }
    }

    private fun showFilterDialog() {
        val dialogView = layoutInflater.inflate(R.layout.filter_layout, null)
        val chipGroup = dialogView.findViewById<ChipGroup>(R.id.chip_group)
        val option1Checkbox = dialogView.findViewById<CheckBox>(R.id.checkbox_option_1)
        val option2Checkbox = dialogView.findViewById<CheckBox>(R.id.checkbox_option_2)
        val applyButton = dialogView.findViewById<Button>(R.id.button_apply)

        // Set up the chip group with your filter options
        val filterOptions = listOf("Option A", "Option B", "Option C")
        for (option in filterOptions) {
            val chip = Chip(requireContext())
            chip.text = option
            chipGroup.addView(chip)
        }

        // Set up the apply button to save the selected filter options and dismiss the dialog
        applyButton.setOnClickListener {
            val selectedOptions = mutableListOf<String>()
            if (option1Checkbox.isChecked) {
                selectedOptions.add("Option 1")
            }
            if (option2Checkbox.isChecked) {
                selectedOptions.add("Option 2")
            }

            // Apply the filter and dismiss the dialog
            applyFilter(selectedOptions)
            filterDialog.dismiss()
        }

        // Create and show the filter dialog
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogView)
        filterDialog = builder.create()
        filterDialog.show()
    }

}