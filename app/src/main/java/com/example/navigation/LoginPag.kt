package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginPage(name:String,age:String,pass:String,navigateBack: (String) -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Box(){
            Button(onClick = {navigateBack(pass) }) {
                Text(text = "Back")
                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow Left")

            }
        }

        Text(text = "Name  $name", fontSize = 24.sp)
        Text(text = "Age$age", fontSize = 24.sp)
        Text(text = "pass$pass", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
    }

}