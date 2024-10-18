package com.example.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun MyApp(){
    val navController= rememberNavController()
    NavHost(navController=navController,startDestination="first-page"){


        composable("first-page"){
            FirstPage {name->
                navController.navigate("ascendance/$name")
            }
        }


        composable("ascendance/{name}"){
            val name=it.arguments?.getString("name") ?: "no name"
            ScendPage(name,
                navigateNext = {age->
                navController.navigate("last-page/$name/$age")},
                navigateBack = { navController.previousBackStackEntry?.savedStateHandle?.set("myname",name)
                    navController.popBackStack()}
            )
        }


        composable("last-page/{name}/{age}"){
        val name=it.arguments?.getString("name") ?: "no name"
        val age=it.arguments?.getString("age") ?: "no age"
            LastPage(name,age,
                navigateNext = {pass->
                navController.navigate("logging/$name/$age/$pass")},
                navigateBack = { navController.previousBackStackEntry?.savedStateHandle?.set("myage",age)
                    navController.popBackStack()}
            )
            }



        composable("logging/{name}/{age}/{pass}"){
            val name=it.arguments?.getString("name") ?: "no name"
            val age=it.arguments?.getString("age") ?: "no age"
            val pass=it.arguments?.getString("pass") ?: "no pass"
            LoginPage(name,age,pass,
                navigateBack = {navController.previousBackStackEntry?.savedStateHandle?.set("mypass",pass)
                    navController.popBackStack()}
            )
        }

    }
}
