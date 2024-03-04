package com.example.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        amb.celularCk.setOnClickListener {
            amb.celularEt.visibility = if (amb.celularCk.isChecked) View.VISIBLE else View.GONE
        }

    }
}