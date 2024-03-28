package com.ubayadev.adv160421017week6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ubayadev.adv160421017week6.R
import com.ubayadev.adv160421017week6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}