package com.example.hbjracademy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.hbjracademy.ui.theme.HBJRAcademyTheme
import androidx.navigation.compose.composable
import com.example.hbjracademy.presentation.list.GamesListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HBJRAcademyTheme {
                Surface(
                    color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.GamesListScreen.route
                    ){

                        composable(
                            route = Screen.GamesListScreen.route
                        ) {
                            GamesListScreen(navController)
                        }
                        composable(
                            route = Screen.GamesDetailScreen.route + "/{gamesId}"
                        ) {
                            GamesListScreen(navController)

                    }

                }
            }
        }
    }
}
/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HBJRAcademyTheme {
        Greeting("Android")
    }*/
}