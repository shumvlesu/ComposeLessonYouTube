package com.shumikhin.composelessonyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Column (Столбец) - это один из видов контейнеров компоуза.
//            Column() {
//                Text(text = "Привет!")
//                Text(text = "Краснодар!")
//                Text(text = "Москва!")
//            }
            //Row() - это тоже контейнер.

            Column( modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize(),//контейнер должен знаять весь экран
                verticalArrangement = Arrangement.Bottom
                ) {
                Row(
                    modifier = Modifier.background(Color.Red),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(text = "Питер!", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Text(text = "Сочи!")
                    Text("hello ".repeat(20), maxLines = 2)
                }

                Row(modifier = Modifier.background(Color.Green).fillMaxHeight(0.5f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = "Краснодар!", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Text(text = "Москва!")
                    //Text("hello ".repeat(20), maxLines = 2)
                }

            }
        }
    }
}