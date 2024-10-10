package com.example.rmp

import android.annotation.SuppressLint
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.rmp.screens.ClimateControlScreen
import com.example.rmp.screens.ElectricityScreen
import com.example.rmp.screens.HomeScreen
import com.example.rmp.screens.SecurityScreen
import com.example.rmp.screens.SensorStatusScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun MainScreen() {
    var selectedIndex by remember { mutableStateOf(4) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFF827568)
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.door_front),
                            contentDescription = "Безопасность"
                        )
                    },
                    label = { Text("Двери", style = TextStyle(
                        fontSize = 10.sp)) },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0 }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.bolt),
                            contentDescription = "Электричество"
                        )
                    },
                    label = { Text("Розетки", style = TextStyle(
                        fontSize = 10.sp)) },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.device_thermostat),
                            contentDescription = "Климат-контроль"
                        )
                    },
                    label = { Text("Климат", style = TextStyle(
                        fontSize = 10.sp)) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.valve),
                            contentDescription = "Состояние"
                        )
                    },
                    label = { Text("Утечки", style = TextStyle(
                        fontSize = 10.sp)) },
                    selected = selectedIndex == 3,
                    onClick = { selectedIndex = 3 }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Rounded.Person,
                            contentDescription = "Пользователь"
                        )
                    },
                    label = { Text("Статус", style = TextStyle(
                        fontSize = 10.sp)) },
                    selected = selectedIndex == 4,
                    onClick = { selectedIndex = 4 }
                )
            }
        }
    ) { pd ->
        when (selectedIndex) {
            0 -> SecurityScreen()
            1 -> ElectricityScreen()
            2 -> ClimateControlScreen()
            3 -> SensorStatusScreen()
            4 -> HomeScreen()
        }
    }
}