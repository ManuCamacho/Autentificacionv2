package com.example.autentificacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autentificacion.databinding.ActivityOlvidoPasswordBinding
import com.example.autentificacion.databinding.ActivityRegistroBinding

class OlvidoPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityOlvidoPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOlvidoPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}