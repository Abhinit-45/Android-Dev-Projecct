package com.example.bankingappui

import androidx.compose.ui.graphics.Brush

data class CardSectionData(
    var cardType:String,
    var cardNumber:String,
    var cardName:String,
    val balance:Double,
    val color:Brush


)
