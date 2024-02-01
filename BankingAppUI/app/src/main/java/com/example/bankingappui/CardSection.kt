package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val PurpleStart = Color(0xFF6200EA)
val PurpleEnd = Color(0xFFB388FF)

val BlueStart = Color(0xFF039BE5)
val BlueEnd = Color(0xFFBBDEFB)

val GreenStart = Color(0xFF4CAF50)
val GreenEnd = Color(0xFFC8E6C9)

val YellowStart = Color(0xFFFFEB3B)
val YellowEnd = Color(0xFFFFF176)


val cards = listOf(
    CardSectionData(
        cardType = "VISA",
        cardNumber = "5456 6578 8756 3456",
        cardName = "Business",
        balance = 275000.56,
        color = getGradient(BlueStart,BlueEnd),
    ),
    CardSectionData(
        cardType = "MASTER CARD",
        cardNumber = "5023 8568 0947 3164",
        cardName = "Trips",
        balance = 115000.356,
        color = getGradient(PurpleStart,PurpleEnd),
    ),

    CardSectionData(
        cardType = "VISA",
        cardNumber = "8940 4578 1900 4839 ",
        cardName = "Savings",
        balance = 25000.10,
        color = getGradient(GreenStart,GreenEnd),
    ),
    CardSectionData(
        cardType = "MASTER CARD",
        cardNumber = "4920 3360 7833 4012",
        cardName = "School",
        balance = 15000.00,
        color = getGradient(YellowStart,YellowEnd),
    )

)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}
@Preview
@Composable
fun CardSection(){
    LazyRow{
        items(cards.size){index->

            CardItem(index)
        }

    }

}
@Composable
fun CardItem(
    index:Int
){
    val card= cards[index]
    var lastItemPaddingEnd=0.dp
    if (index== cards.size-1)
    {
        lastItemPaddingEnd=16.dp
    }

    var image= painterResource(id = R.drawable.visa)
    if (card.cardType=="MASTER CARD"){
        image= painterResource(id = R.drawable.mastercard)
    }
    Box(modifier = Modifier.padding(start = 16.dp,end=lastItemPaddingEnd))
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween

        ) {
          Image(painter = image, contentDescription =card.cardName,
              modifier =Modifier.width(60.dp)
          )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " ₹ ${card.balance} ",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}