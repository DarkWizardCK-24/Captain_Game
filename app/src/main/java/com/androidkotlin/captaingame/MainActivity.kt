package com.androidkotlin.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidkotlin.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CaptainGame()
                }
            }
        }
    }

    @Composable
    fun CaptainGame(){
        val treasuresFound = remember { mutableStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormOrTreasure = remember { mutableStateOf("") }
        val pirates = remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Treasure Found : ${treasuresFound.value}")
            Text(text = "Current Direction : ${direction.value}")
            Text(text = "${stormOrTreasure.value}")
            Text(text = "${pirates.value}")
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Button(onClick = {
                    direction.value = "East"
                    if (Random.nextBoolean()){
                        treasuresFound.value += 1
                        stormOrTreasure.value = "WE FOUND A TREASURE !!!"
                    } else {
                        stormOrTreasure.value = "STORM AHEAD !!!"
                    }
                }) {
                    Text("Sail East")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = {
                    direction.value = "West"
                    if (Random.nextBoolean()){
                        treasuresFound.value += 1
                        stormOrTreasure.value = "WE FOUND A TREASURE !!!"
                    } else {
                        stormOrTreasure.value = "STORM AHEAD !!!"
                    }
                }) {
                    Text("Sail West")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Button(onClick = {
                    direction.value = "North"
                    if (Random.nextBoolean()){
                        treasuresFound.value += 1
                        stormOrTreasure.value = "WE FOUND A TREASURE !!!"
                    } else {
                        stormOrTreasure.value = "STORM AHEAD !!!"
                    }
                }) {
                    Text("Sail North")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = {
                    direction.value = "South"
                    if (Random.nextBoolean()){
                        treasuresFound.value += 1
                        stormOrTreasure.value = "WE FOUND A TREASURE !!!"
                    } else {
                        stormOrTreasure.value = "STORM AHEAD !!!"
                    }
                }) {
                    Text("Sail South")
                }
            }
        }
    }
}
