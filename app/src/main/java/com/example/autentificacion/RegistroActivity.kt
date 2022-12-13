package com.example.autentificacion

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.autentificacion.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BRegistrar.setOnClickListener {
            if (binding.Enombre.text.isNotEmpty() && binding.Eapellidos.text.isNotEmpty()
                && binding.Eemail.text.isNotEmpty() && binding.Epassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.Eemail.text.toString(),
                    binding.Epassword.text.toString()
                ).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, InicioActivity::class.java).apply {
                            putExtra("nombreusuario",binding.Enombre.text.toString())
                        }
                        startActivity(intent)
                    }else {Toast.makeText(this, "No se ha creado el usuario", Toast.LENGTH_SHORT).show()}
                }


            } else {
                Toast.makeText(this, "Algun campo esta vacio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}