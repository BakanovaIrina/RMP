package com.example.rmp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rmp.viewModel.SecurityViewModel

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun SecurityScreen(viewModel: SecurityViewModel = viewModel()) {
    val sensorStates by viewModel.sensorStates.collectAsState()
    val doorHistory by viewModel.doorHistory.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Безопасность",
                        style = TextStyle(
                            fontSize = 24.sp)
                    )
                },
                backgroundColor = Color(0xFF827568)
            )
        }
    ) {  pd ->
        Column(
            modifier = Modifier.padding(16.dp, 24.dp, 16.dp, 0.dp)
        ) {
            Text(text = "Датчики разбития окон", style = TextStyle(fontSize = 18.sp))
            sensorStates.forEach { sensor ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 4.dp, 0.dp, 4.dp)
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Text(text = sensor.name, modifier = Modifier.weight(1f))
                        val color =
                            if (sensor.isBroken) MaterialTheme.colors.error else MaterialTheme.colors.primary
                        Text(text = if (sensor.isBroken) "Broken" else "OK", color = color)
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "История открытия дверей", style = TextStyle(fontSize = 18.sp))

            doorHistory.forEach { record ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 4.dp, 0.dp, 4.dp)
                ) {
                    Row(modifier = Modifier.padding(8.dp)){
                        Text(text = record.time, modifier = Modifier.weight(1f))
                        Text(text = record.action)
                    }
                }
            }
        }
    }
}