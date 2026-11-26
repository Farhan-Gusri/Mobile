package com.example.mars_farhan3tie.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.Pertemuan10.FragmentMore
import com.example.mars_farhan3tie.R
import com.example.mars_farhan3tie.pertemuan_9.NinthActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPertemuan9 = view.findViewById<Button>(R.id.btnPertemuan9)
        val btnPertemuan10 = view.findViewById<Button>(R.id.btnPertemuan10)

        btnPertemuan9?.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        btnPertemuan10?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentMore())
                .addToBackStack(null)
                .commit()
        }
    }
}