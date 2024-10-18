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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LastPage(name:String, age:String, navigateNext: (String) -> Unit,navigateBack: (String) -> Unit) {
    val pass = remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Box(){
            Button(onClick = { navigateBack(age) }) {
                Text(text = "Back")
                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow Left")

            }
        }
        
        Text(text = "Name  $name",fontSize = 24.sp)
        Text(text = "Age$age",fontSize = 24.sp)
        Text(text = "put your pass")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = pass.value,
            onValueChange = { pass.value = it
                isError=it.isEmpty()},
            isError=isError,
            label = { Text("pass") }
        )
        if (isError) {
            Text(
                text = "pass is required",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (pass.value.isEmpty()) {
                isError = true
            } else {
                navigateNext(pass.value)
            }
        }) {
            Text(text = "Next")
        }
    }
}