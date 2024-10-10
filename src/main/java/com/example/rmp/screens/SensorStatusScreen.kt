package com.example.rmp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.rmp.viewModel.SensorStateViewModel
import com.example.rmp.viewModel.SensorStatusItem

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun SensorStatusScreen(viewModel: SensorStateViewModel = viewModel()) {

    val gasLeakDetected by viewModel.gasLeakDetected.collectAsState()
    val waterLeakDetected by viewModel.waterLeakDetected.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Датчики протечки",
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

            SensorStatusItem(
                sensorName = "Протечка газа",
                isLeakDetected = gasLeakDetected
            )

            Spacer(modifier = Modifier.height(24.dp))

            SensorStatusItem(
                sensorName = "Протечка воды",
                isLeakDetected = waterLeakDetected
            )
        }
    }
}