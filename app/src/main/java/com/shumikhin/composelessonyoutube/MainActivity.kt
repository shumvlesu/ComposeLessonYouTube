package com.shumikhin.composelessonyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewText()
        }
    }
}

@Preview(showBackground = true) // showBackground = true - показывать бэкграунд у виджета
//Аннотация @Preview позволяет сразу видеть изменения в окне предпросмотра
@Composable
fun NewText() {
    Text(text = "Привет!")
}