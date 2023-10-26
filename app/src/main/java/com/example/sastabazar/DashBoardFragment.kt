package com.example.sastabazar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sastabazar.databinding.FragmentDashBoardBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class DashBoardFragment : Fragment() {

    lateinit var binding: FragmentDashBoardBinding
    lateinit var productList: ArrayList<ProductModel>
    lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productList = ArrayList()
        productList = getProductData()

        adapter = ProductAdapter(requireContext(),productList)
        binding.mainRv.adapter=adapter
        getProductData()

    }

    private fun getProductData(): ArrayList<ProductModel> {
        var tempProductList = arrayListOf<ProductModel>()

        Firebase.firestore.collection("Product").get().addOnSuccessListener {
            for (i in it.documents){

                var tempProductModel = i.toObject<ProductModel>()
                tempProductList.add(tempProductModel!!)
            }
            return@addOnSuccessListener
        }
        return tempProductList

    }

    companion object {



    }
}