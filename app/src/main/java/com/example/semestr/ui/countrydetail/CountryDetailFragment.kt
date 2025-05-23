package com.example.semestr.ui.countrydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.semestr.R
import com.example.semestr.databinding.FragmentCountryDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailFragment : Fragment() {

    private var _binding: FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!
    private val args: CountryDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val country = args.country
        binding.tvName.text = country.name.common
        binding.tvCapital.text =
            getString(R.string.capital, country.capital?.joinToString() ?: "N/A")
        binding.tvRegion.text = getString(R.string.region, country.region)
        binding.tvPopulation.text = getString(R.string.population, country.population)
        Glide.with(this).load(country.flags.png).into(binding.ivFlag)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}