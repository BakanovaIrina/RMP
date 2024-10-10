package com.example.rmp.viewModel

import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClimateControlViewModel : ViewModel() {
    private val _temperature = MutableStateFlow(22f)
    val temperature: StateFlow<Float> = _temperature

    private val _humidity = MutableStateFlow(45)
    val humidity: StateFlow<Int> = _humidity

    private val _floorHeatingTemperature = MutableStateFlow(22f)
    val floorHeatingTemperature: StateFlow<Float> = _floorHeatingTemperature

    fun setTemperature(newTemperature: Float) {
        _temperature.value = newTemperature
        sendTemperatureToServer(newTemperature)
    }

    fun setFloorHeatingTemperature(newTemperature: Float) {
        _floorHeatingTemperature.value = newTemperature
        sendFloorHeatingStatusToServer(newTemperature)
    }

    private fun sendTemperatureToServer(newTemperature: Float) {
        viewModelScope.launch {
            println("Temperature sent to server: $newTemperature")
        }
    }

    private fun sendFloorHeatingStatusToServer(newTemperature: Float) {
        viewModelScope.launch {
            println("Temperature sent to server: $newTemperature")
        }
    }
}