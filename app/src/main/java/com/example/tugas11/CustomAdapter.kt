package com.example.tugas11

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mars_farhan3tie.databinding.ItemRekomendasiBinding

class DataItem(
    val judul: String,
    val keterangan: String,
    val ikon: Int
)

class CustomAdapter(private val listData: List<DataItem>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRekomendasiBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRekomendasiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        holder.binding.tvJudulItem.text = item.judul
        holder.binding.tvSubItem.text = item.keterangan
        holder.binding.ivIconItem.setImageResource(item.ikon)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Anda memilih: ${item.judul}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listData.size
}