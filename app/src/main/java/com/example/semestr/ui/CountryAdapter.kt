package com.example.semestr.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semestr.databinding.ItemCountryBinding
import com.example.semestr.model.Country
import com.example.semestr.R

class CountryAdapter(
    private val onItemClick: (Country) -> Unit
) : ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding =
            ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.tvCountryName.text = country.name.common
            Glide.with(binding.ivFlag.context)
                .load(country.flags.png)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(binding.ivFlag)
            binding.root.setOnClickListener { onItemClick(country) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country) =
            oldItem.name.common == newItem.name.common

        override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem == newItem
    }
}