package com.example.navigationdeeplinkapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.navigationdeeplinkapp.R
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDetail = view.findViewById<MaterialButton>(R.id.btnDetail)
        val etName = view.findViewById<EditText>(R.id.etName)

        btnDetail.setOnClickListener {
            val name = etName.text.toString()

            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(name = name))
        }

    }

}