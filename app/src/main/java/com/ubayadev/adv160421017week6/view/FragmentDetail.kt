package com.ubayadev.adv160421017week6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubayadev.adv160421017week6.R
import com.ubayadev.adv160421017week6.databinding.FragmentDetailBinding
import com.ubayadev.adv160421017week6.viewmodel.DetailViewModel

class FragmentDetail : Fragment() {
    private lateinit var binding:FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = FragmentDetailArgs.fromBundle(requireArguments()).id
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            binding.txtAge.setText(it.age.toString() + " years old")
            binding.txtNilai1.setText(it.scores[0].toString())
            binding.txtNilai2.setText(it.scores[1].toString())
            binding.txtNilai3.setText(it.scores[2].toString())
            binding.txtID.setText(it.id.toString())
            binding.txtName.setText(it.name)
            binding.txtStreet.setText(it.address.street)
            binding.txtCity.setText(it.address.city)
            binding.txtCountry.setText(it.address.country)
        })

    }
}