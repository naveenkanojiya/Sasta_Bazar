package com.example.sastabazar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sastabazar.databinding.ActivitySingUpLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SingUpLoginActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySingUpLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signUpLogin.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(
                binding.email.text.toString(),
                binding.pass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this@SingUpLoginActivity,"User Created",Toast.LENGTH_LONG)
                        .show()
                }else{
                    Toast.makeText(
                        this@SingUpLoginActivity,
                        it.exception?.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
    }
}