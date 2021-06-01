package com.example.new1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.new1.databinding.FragmentOneBinding
import com.example.new1.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    private var _binding: FragmentTwoBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            if(binding.editTextTextPassword.text.toString()=="123456"){
                startActivity(Intent(requireContext(), HomeActivity::class.java))
            }
        }
    }
}