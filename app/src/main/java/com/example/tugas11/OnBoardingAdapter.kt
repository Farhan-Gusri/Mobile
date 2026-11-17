package com.example.tugas11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mars_farhan3tie.databinding.ItemOnboardingBinding

data class OnBoardingItem(
    val judul: String,
    val deskripsi: String,
    val ikon: Int
)

class OnBoardingAdapter(private val items: List<OnBoardingItem>) :
    RecyclerView.Adapter<OnBoardingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.ivOnBoarding.setImageResource(item.ikon)
        holder.binding.tvTitleOnBoarding.text = item.judul
        holder.binding.tvDescOnBoarding.text = item.deskripsi
    }

    override fun getItemCount(): Int = items.size
}