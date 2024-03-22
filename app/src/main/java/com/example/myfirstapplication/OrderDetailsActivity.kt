package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    var order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)


        order.productName = intent.getStringExtra("order").toString()

        binding.txtPlacedOrder.text = order.productName

        when(order.productName){
            "Soy Latte" -> binding.imageView8.setImageResource(R.drawable.sb1)
            "Chocco Fap" -> binding.imageView8.setImageResource(R.drawable.sb2)
            "Bottled AmericaNO" -> binding.imageView8.setImageResource(R.drawable.sb3)
            "Rainbow fap" -> binding.imageView8.setImageResource(R.drawable.sb4)
            "Caramel Fap" -> binding.imageView8.setImageResource(R.drawable.sb5)
            "Black Forest Fap" -> binding.imageView8.setImageResource(R.drawable.sb6)
        }

        binding.fab.setOnClickListener(){
            shareIntent(applicationContext, order.productName)
        }

    }




}