package com.shumikhin.composelessonyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty1)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty2)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty3)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty4)
            }
        }
    }
}


@Composable
private fun ListItem(name: String, prof: String, pic: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), //Растягиваем карточку по ширине род элемента (активити). И делаем отсутп.
        shape = RoundedCornerShape(15.dp), //Закругляем углы у карточки
        elevation = 5.dp //Это такая левитация как бы над родителем.
    ) {
        Box() {
            //CenterVertically - Центр по вертикали
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = pic),
                    contentDescription = "My kitty",
                    contentScale = ContentScale.Crop, //Указываем как обрезать картинку.
                    modifier = Modifier
                        .padding(5.dp) //Отсуп у картинки
                        //Рисую белую окантовку
                        .border(
                            BorderStroke(2.dp, Color.White),
                            CircleShape
                        )
                        .size(64.dp) //Размер
                        .clip(CircleShape) //Вид Обрезки
                        //Пытался сделать эффект возвышения, это так тут не работает. Пока оставлю.
                        .shadow(elevation = 10.dp,
                            shape = CircleShape,
                            clip = true)

                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = name)
                    Text(text = prof)
                }
            }
        }
    }

}