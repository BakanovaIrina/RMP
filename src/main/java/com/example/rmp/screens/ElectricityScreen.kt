package com.example.rmp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rmp.viewModel.ElectricityViewModel
import com.example.rmp.card.RoomCard
import com.example.rmp.card.SocketCard

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun ElectricityScreen(viewModel: ElectricityViewModel = viewModel()) {
    val rooms by viewModel.rooms.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Управление электричеством",
                        style = TextStyle(fontSize = 24.sp)
                    )
                },
                backgroundColor = Color(0xFF827568)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 16.dp, 16.dp, 64.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Выключить весь свет", modifier = Modifier.weight(1f))
                val allLightsOn = rooms.all { it.lightsOn }
                Switch(
                    checked = allLightsOn,
                    onCheckedChange = { isOn ->
                        viewModel.toggleAllLights(isOn)
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Выключить все розетки", modifier = Modifier.weight(1f))
                val allSocketsOn = rooms.all { room -> room.sockets.all { it.isOn } }
                Switch(
                    checked = allSocketsOn,
                    onCheckedChange = { isOn ->
                        viewModel.toggleAllSockets(isOn)
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Точки электричества", style = TextStyle(fontSize = 24.sp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(rooms) { room ->
                    RoomCard(room = room, viewModel = viewModel)
                }

                items(rooms) { room ->
                    room.sockets.forEach { socket ->
                        SocketCard(roomName = room.name, socket = socket, viewModel = viewModel)
                    }
                }
            }

            Text(
                text = "Розетки", style = TextStyle(fontSize = 24.sp)
            )

        }
    }
}