package com.example.rmp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
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
import com.example.rmp.viewModel.ClimateControlViewModel

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun ClimateControlScreen(viewModel: ClimateControlViewModel = viewModel()) {
    val temperature by viewModel.temperature.collectAsState()
    val humidity by viewModel.humidity.collectAsState()
    val floorHeating by viewModel.floorHeatingTemperature.collectAsState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Климат-контроль",
                        style = TextStyle(
                            fontSize = 24.sp)
                    )
                },
                backgroundColor = Color(0xFF827568)
            )
        }
    ) {  pd ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Температура: ${"%.1f".format(temperature)}°C")
            Slider(
                value = temperature,
                onValueChange = { viewModel.setTemperature(it) },
                valueRange = 16f..30f,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Влажность: ${humidity}%")

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Температура пола: ${"%.1f".format(floorHeating)}°C")
            Slider(
                value = floorHeating,
                onValueChange = { viewModel.setFloorHeatingTemperature(it) },
                valueRange = 16f..30f,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }


}