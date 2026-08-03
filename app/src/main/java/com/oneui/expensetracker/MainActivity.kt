package com.oneui.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oneui.expensetracker.ui.screens.AddExpenseScreen
import com.oneui.expensetracker.ui.screens.ExpenseListScreen
import com.oneui.expensetracker.ui.theme.ExpenseTrackerTheme
import com.oneui.expensetracker.viewmodel.ExpenseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ExpenseApp()
                }
            }
        }
    }
}

@Composable
fun ExpenseApp() {
    val navController: NavHostController = rememberNavController()
    val viewModel: ExpenseViewModel = viewModel()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ExpenseListScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate("add") }
            )
        }
        composable("add") {
            AddExpenseScreen(
                viewModel = viewModel,
                onDone = { navController.popBackStack() }
            )
        }
    }
}
