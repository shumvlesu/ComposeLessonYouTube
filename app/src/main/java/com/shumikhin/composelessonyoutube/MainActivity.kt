package com.shumikhin.composelessonyoutube

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Что-бы можно было скроллить контейнер со множеством вложенных элементов
            //можно добваить в модификатор - verticalScroll. И указать ему параметр rememberScrollState()
            //что-бы сохранялось положение элементов внутри контейнера (Состояние до куда мы проскролили).
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty1)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty2)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty3)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty4)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty3)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty1)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty4)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty2)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty4)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty3)
                ListItem("Моя Кошка!", "Мне очень нравится эта картинка.", R.drawable.kitty1)
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
            .padding(10.dp) //Растягиваем карточку по ширине род элемента (активити). И делаем отсутп.
//            .clickable {
////                Toast
////                    .makeText( this, "Хоба!", Toast.LENGTH_LONG)
////                    .show()
//                Log.d("MyCard", "Нажал карточку.")
//            }
            //pointerInput - помогает отслеживать какаие действия происходят с этим элементом.
            //долго жмут на карточку, проводят пальцем и подобное.
            .pointerInput(Unit) {

                //Здесь можно задавать бесконечное количество разных слушателей. Но работать будет только самый верхний.
                detectTapGestures {
                    Log.d("MyCard", "Нажимал на карточку, координата относительно лвого верхнего угла. - $it")
                }

                //отслеживаем долгое нажатие
//                detectDragGesturesAfterLongPress { change, dragAmount ->
//                    Log.d("MyCard", "Нажимал на карточку долго по координатам карточки (координата относительно того где нажал)- $dragAmount")
//                }

            },
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
                        .shadow(
                            elevation = 10.dp,
                            shape = CircleShape,
                            clip = true
                        )

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