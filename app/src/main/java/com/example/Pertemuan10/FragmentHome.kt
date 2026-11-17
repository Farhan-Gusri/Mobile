package com.example.Pertemuan10

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.Pertemuan11.TenthActivity
import com.example.mars_farhan3tie.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol Pertemuan 10 (isi dengan Intent ke Activity Pertemuan 10 Anda)
        binding.btnPertemuan10.setOnClickListener {
            // val intent = Intent(requireContext(), NamaActivityPertemuan10::class.java)
            // startActivity(intent)
        }

        // Tombol Pertemuan 11 menuju ke TenthActivity (sesuaikan ID btnPertemuan11 dengan XML Anda)
        binding.btnPertemuan9.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}