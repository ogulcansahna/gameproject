package com.example.hbjracademy.ui.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hbjracademy.ui.navigation.Navigation
import com.example.hbjracademy.ui.navigation.NavigationItem
import com.example.hbjracademy.ui.theme.ColorPrimary
import com.example.hbjracademy.ui.theme.HBJRAcademyTheme

@ExperimentalMaterialApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sp:SharedPreferences
        sp=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        setContent {
            HBJRAcademyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBarItems = listOf(NavigationItem.Home, NavigationItem.Favorite)
    val showNavBar = navController
        .currentBackStackEntryAsState().value?.destination?.route in navBarItems.map {
        it.route
    }

    Scaffold(bottomBar = {
        if (showNavBar) {
            BottomNavigationBar(navController = navController, navBarItems)
        }
    }) {

        Navigation(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, items: List<NavigationItem>) {
    Card(
        modifier = Modifier
            .height(74.dp)
            .fillMaxWidth()
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()

        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = ColorPrimary
        ) {
            items.forEach { item ->
                val isSelected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon!!),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    selectedContentColor = ColorPrimary,
                    unselectedContentColor = Color.Gray,
                    alwaysShowLabel = false,
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route = route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}