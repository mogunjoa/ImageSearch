package com.mogun.mediasearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mogun.mediasearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }

    }
}