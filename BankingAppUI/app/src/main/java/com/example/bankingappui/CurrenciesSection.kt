package com.example.bankingappui

import android.inputmethodservice.Keyboard.Row
import android.text.Layout.Alignment
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyLira
import androidx.compose.material.icons.rounded.CurrencyRuble
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Currency

val currencies = listOf(
    CurrencyData(
        name = "RUPEE",
        buy = 230.35f,
        sell = 250.67f,
        icon = Icons.Rounded.CurrencyRupee

    ),
    CurrencyData(
        name = "USD",
        buy = 23.35f,
        sell = 25.67f,
        icon = Icons.Rounded.AttachMoney

    ),
    CurrencyData(
        name = "EURO",
        buy = 43.35f,
        sell = 55.07f,
        icon = Icons.Rounded.Euro

    ),
    CurrencyData(
        name = "YEN",
        buy = 13.5f,
        sell = 20.57f,
        icon = Icons.Rounded.CurrencyYen

    ),
    CurrencyData(
        name = "LIRA",
        buy = 223.15f,
        sell = 225.07f,
        icon = Icons.Rounded.CurrencyLira

    ),
    CurrencyData(
        name = "RUBLE",
        buy = 33.3f,
        sell = 36.00f,
        icon = Icons.Rounded.CurrencyRuble

    ),
)

@Preview
@Composable

fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = androidx.compose.ui.Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        if (isVisible) {
                            iconState = Icons.Rounded.KeyboardArrowUp
                        } else {
                            iconState = Icons.Rounded.KeyboardArrowDown
                        }
                    }
                )

                Icon(
                    modifier = Modifier
                        .size(25.dp), imageVector = iconState, contentDescription = "Currencies",
                    tint = MaterialTheme.colorScheme.onSecondary

                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Currencies",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )

        if (isVisible) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val boxWithConstraintsScope = this
                val width = boxWithConstraintsScope.maxWidth / 3

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.width(width),
                            text = "Currency",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )

                        Text(
                            modifier = Modifier.width(width),
                            text = "Buy",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End

                        )

                        Text(
                            modifier = Modifier.width(width),
                            text = "Sell",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End

                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn {
                        items(currencies.size) { index ->
                            CurrencyItem(
                                index = index,
                                width = width
                            )
                        }

                    }
                }
            }
        }

    }
}
@Composable
fun CurrencyItem(index: Int, width: Dp) {

    val currency = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.width(width),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {


        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = currency.icon,
                contentDescription = currency.name,
                tint = Color.White
            )
        }
        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = currency.name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
    }
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )


    }


}
