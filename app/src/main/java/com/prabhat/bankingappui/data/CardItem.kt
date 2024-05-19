package com.prabhat.bankingappui.data

import androidx.compose.ui.graphics.Brush

data class CardItem(
    val cardType:String,
    val cardNumber:String,
    val cardName:String,
    val balance:Double,
    val color: Brush,
)
