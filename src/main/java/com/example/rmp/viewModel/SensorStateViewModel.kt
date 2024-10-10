package com.example.rmp.viewModel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SensorStateViewModel : ViewModel() {
    private val _gasLeakDetected = MutableStateFlow(false)
    val gasLeakDetected: StateFlow<Boolean> get() = _gasLeakDetected

    private val _waterLeakDetected = MutableStateFlow(false)
    val waterLeakDetected: StateFlow<Boolean> get() = _waterLeakDetected

    fun setGasLeakDetected(detected: Boolean) {
        _gasLeakDetected.value = detected
    }

    fun setWaterLeakDetected(detected: Boolean) {
        _waterLeakDetected.value = detected
    }
}

@Composable
fun SensorStatusItem(
    sensorName: String,
    isLeakDetected: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = sensorName, modifier = Modifier.weight(1f))
        val statusText = if (isLeakDetected) "Утечка" else "Нет утечки"
        val statusColor = if (isLeakDetected) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
        Text(text = statusText, color = statusColor)
    }
}
