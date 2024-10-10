package com.example.rmp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


data class SensorState(val name: String, val isBroken: Boolean)
data class DoorHistory(val time: String, val action: String)


class SecurityViewModel : ViewModel() {
    private val _sensorStates = MutableStateFlow<List<SensorState>>(emptyList())
    val sensorStates: StateFlow<List<SensorState>> = _sensorStates

    private val _doorHistory = MutableStateFlow<List<DoorHistory>>(emptyList())
    val doorHistory: StateFlow<List<DoorHistory>> = _doorHistory

    init {
        viewModelScope.launch {
            loadSensorStates()
            loadDoorHistory()
        }
    }

    private suspend fun loadSensorStates() {
        delay(100)
        _sensorStates.value = listOf(
            SensorState("Окно 1", false),
            SensorState("Окно 2", true),
            SensorState("Окно 3", false)
        )
    }

    private suspend fun loadDoorHistory() {
        delay(100)
        _doorHistory.value = listOf(
            DoorHistory("2024-06-05 10:00", "Открыта"),
            DoorHistory("2024-06-05 10:01", "Закрыта"),
            DoorHistory("2024-06-04 22:00", "Открыта"),
            DoorHistory("2024-06-04 22:01", "Закрыта")
        )
    }
}
