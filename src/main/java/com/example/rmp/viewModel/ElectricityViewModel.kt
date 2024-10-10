package com.example.rmp.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


data class Socket(val id: Int, var isOn: Boolean)

data class Room(val name: String, val lightsOn: Boolean, val sockets: List<Socket>)

class ElectricityViewModel : ViewModel() {
    private val _rooms = MutableStateFlow<List<Room>>(emptyList())
    val rooms: StateFlow<List<Room>> = _rooms

    init {
        loadRooms()
    }

    private fun loadRooms() {
        val roomsData = listOf(
            Room(
                name = "Спальня 1",
                lightsOn = true,
                sockets = listOf(Socket(1, true), Socket(2, true))
            ),
            Room(
                name = "Кухня",
                lightsOn = true,
                sockets = listOf(Socket(2, true), Socket(3, true))
            ),
            Room(
                name = "Спальня 2",
                lightsOn = true,
                sockets = listOf(Socket(3, true), Socket(4, true), Socket(5, true))
            ),
            Room(
                name = "Санузел 1",
                lightsOn = true,
                sockets = listOf(Socket(4, true), Socket(6, true))
            ),
            Room(
                name = "Санузел 2",
                lightsOn = false,
                sockets = listOf(Socket(5, true), Socket(7, true))
            ),
            Room(
                name = "Гостинная",
                lightsOn = false,
                sockets = listOf(Socket(6, true), Socket(8, true))
            ),

        )
        _rooms.value = roomsData
    }
    fun toggleAllSockets(isOn: Boolean) {
        _rooms.value = _rooms.value.map { room ->
            room.copy(sockets = room.sockets.map { it.copy(isOn = isOn) })
        }
    }

    fun toggleAllLights(isOn: Boolean) {
        _rooms.value = _rooms.value.map { room ->
            room.copy(lightsOn = isOn)
        }
    }

    fun toggleRoomLights(roomName: String, isOn: Boolean) {
        _rooms.value = _rooms.value.map { room ->
            if (room.name == roomName) {
                room.copy(lightsOn = isOn)
            } else {
                room
            }
        }
    }

    fun toggleSocket(roomName: String, socketId: Int, isOn: Boolean) {
        _rooms.value = _rooms.value.map { room ->
            if (room.name == roomName) {
                room.copy(sockets = room.sockets.map { socket ->
                    if (socket.id == socketId) {
                        socket.copy(isOn = isOn)
                    } else {
                        socket
                    }
                })
            } else {
                room
            }
        }
    }
}



