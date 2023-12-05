package com.example.sastabazar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.sastabazar.databinding.ActivityDetailsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class DetailsActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }
    var productModel = ProductModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var productId = intent.getStringExtra("PRODUCT_ID")

        Firebase.firestore.collection("Product")
            .document(productId!!).get().addOnSuccessListener {

                productModel = it.toObject<ProductModel>()!!
                productModel.id = it.id
                binding.productImage.load(productModel.imageUrl)

            }


    }
}