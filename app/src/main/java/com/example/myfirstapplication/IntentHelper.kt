package com.example.myfirstapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction


fun openIntent(context: Context, order: String, activityToOpen: Class<*>){
    val activityContext = context as? Activity ?: return

    val intent  = Intent(activityContext, activityToOpen)

    intent.putExtra("order",order)

    context.startActivity(intent)
}

fun shareIntent(context: Context, order: String){
    var sendIntent = Intent()
    sendIntent.setAction(Intent.ACTION_SEND)

    sendIntent.putExtra(Intent.EXTRA_TEXT, order)

    sendIntent.setType("text/plain")

    var shareIntent = Intent.createChooser(sendIntent, null)

    context.startActivity(shareIntent)

    fun shareIntent(Context: Context, order: Order){
        var sendIntent = Intent()
        sendIntent.setAction(Intent.ACTION_SEND)

        var shareOrderDetails = Bundle()

        shareOrderDetails.putString("productName", order.productName)
        shareOrderDetails.putString("customerName", order.customerName)
        shareOrderDetails.putString("customerCell", order.customerCell)

        sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)

        sendIntent.setType("text/plain")

        var shareIntent =  Intent.createChooser(sendIntent, null)
        content.shareActivity(shareIntent)
    }
}