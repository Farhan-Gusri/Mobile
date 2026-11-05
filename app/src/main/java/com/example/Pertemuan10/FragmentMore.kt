package com.example.Pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import com.example.mars_farhan3tie.databinding.FragmentMoreBinding

class FragmentMore : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = "Pertemuan 10 (ListView)"

        val menuList = listOf("Simple Adapter", "Custom Adapter (Message)")
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            menuList
        )
        binding.listViewItems.adapter = adapter

        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    showSimpleAdapterData()
                }
                1 -> {
                    parentFragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(android.R.id.content, FragmentMessage())
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    private fun showSimpleAdapterData() {
        binding.toolbar.title = "Simple Adapter Demo"

        val titles = arrayOf("Kotlin", "Java", "Python", "C++", "JavaScript")
        val descriptions = arrayOf(
            "Bahasa untuk Android modern",
            "Bahasa OOP yang populer",
            "Bahasa yang mudah dipahami",
            "Bahasa tingkat tinggi yang cepat",
            "Bahasa web terpopuler"
        )

        val dataList = ArrayList<HashMap<String, String>>()

        for (i in 0 until titles.size) {
            val item = HashMap<String, String>()
            item["title"] = titles[i]
            item["description"] = descriptions[i]
            dataList.add(item)
        }

        val from = arrayOf("title", "description")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val simpleAdapter = SimpleAdapter(
            requireContext(),
            dataList,
            android.R.layout.simple_list_item_2,
            from,
            to
        )

        binding.listViewItems.adapter = simpleAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}