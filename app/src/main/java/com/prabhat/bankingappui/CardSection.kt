package com.prabhat.bankingappui

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
import com.prabhat.bankingappui.data.CardItem
import com.prabhat.bankingappui.ui.theme.BlueEnd
import com.prabhat.bankingappui.ui.theme.BlueStart
import com.prabhat.bankingappui.ui.theme.GreenEnd
import com.prabhat.bankingappui.ui.theme.GreenStart
import com.prabhat.bankingappui.ui.theme.PurpleEnd
import com.prabhat.bankingappui.ui.theme.PurpleStart


val cards = listOf(
    CardItem(
        cardType = "VISA",
        cardNumber = "2343 1233 2344 1343",
        cardName = "Business",
        balance = 123.23,
        color = getGradient(PurpleStart, PurpleEnd)

    ),
    CardItem(
        cardType = "MASTER CARD",
        cardNumber = "1343 2253 8944 1093",
        cardName = "Savings",
        balance = 23.23,
        color = getGradient(BlueStart, BlueEnd)

    ),
    CardItem(
        cardType = "VISA",
        cardNumber = "2343 1233 2344 1343",
        cardName = "Trips",
        balance = 3.23,
        color = getGradient(GreenStart, GreenEnd)

    ),

    )

fun getGradient(
    startColor: Color, endColor: Color
): Brush {

    return Brush.horizontalGradient(colors = listOf(startColor, endColor))

}

@Preview
@Composable
fun CardSection() {


    LazyRow {
        items(cards.size) { index ->

            CardItems(index)
        }
    }
}

@Composable
fun CardItems(index: Int) {

    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(150.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween


        ) {


            Image(painter = image,
                contentDescription = "",
                modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
                )
            Text(text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }


}