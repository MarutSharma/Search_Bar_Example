package com.example.searchexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.searchexample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val data: List<String> = loadData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.isSubmitButtonEnabled = true
        binding.searchView.setOnQueryTextListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadData(): List<String> {
        return listOf<String>(
            "Hello",
            "Hi",
            "This",
            "That"
        )
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        binding.textviewFirst.text = ""
        if (query?.isNotEmpty() == true) {
            for (item in data) {
                if (item.contains(query, true)) {
                    binding.textviewFirst.append("$item found\n")
                }
            }
            return true
        }
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

}