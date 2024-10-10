package com.example.rmp.card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rmp.viewModel.ElectricityViewModel
import com.example.rmp.viewModel.Room

@Composable
fun RoomCard(room: Room, viewModel: ElectricityViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Освещение " + room.name, modifier = Modifier.weight(1f))
            Switch(
                checked = room.lightsOn,
                onCheckedChange = { isOn ->
                    viewModel.toggleRoomLights(room.name, isOn)
                }
            )
        }
    }
}