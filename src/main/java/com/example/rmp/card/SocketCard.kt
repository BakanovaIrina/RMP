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
import com.example.rmp.viewModel.Socket

@Composable
fun SocketCard(roomName: String, socket: Socket, viewModel: ElectricityViewModel) {
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
            Text(text = "Розетка ${socket.id} в $roomName", modifier = Modifier.weight(1f))
            Switch(
                checked = socket.isOn,
                onCheckedChange = { isOn ->
                    viewModel.toggleSocket(roomName, socket.id, isOn)
                }
            )
        }
    }
}