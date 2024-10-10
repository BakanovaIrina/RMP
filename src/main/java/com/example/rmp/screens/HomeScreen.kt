package com.example.rmp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Недвижимость",
                        style = TextStyle(
                            fontSize = 24.sp)
                    )
                },
                backgroundColor = Color(0xFF827568)
            )
        }
    ) { pd ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pd)
                .padding(16.dp)
        ) {
            Text(text = "Статус системы", style = MaterialTheme.typography.h5)

            Text(text = "Тип недвижимости: Дом", style = MaterialTheme.typography.h6)
            Text(text = "Статус: ОК", style = MaterialTheme.typography.body1)
            Text(text = "Количество комнат: 3", style = MaterialTheme.typography.body1)
            Text(text = "Площадь: 120 м²", style = MaterialTheme.typography.body1)
            Text(text = "Адрес: Улица Примерная, дом 1", style = MaterialTheme.typography.body1)
        }
    }

}