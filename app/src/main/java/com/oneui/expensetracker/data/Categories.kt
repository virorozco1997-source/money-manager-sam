package com.oneui.expensetracker.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.ui.graphics.vector.ImageVector

data class ExpenseCategory(val name: String, val icon: ImageVector)

val expenseCategories = listOf(
    ExpenseCategory("Comida", Icons.Filled.Restaurant),
    ExpenseCategory("Transporte", Icons.Filled.DirectionsCar),
    ExpenseCategory("Compras", Icons.Filled.ShoppingBag),
    ExpenseCategory("Hogar", Icons.Filled.Home),
    ExpenseCategory("Salud", Icons.Filled.LocalHospital),
    ExpenseCategory("Ocio", Icons.Filled.SportsEsports),
    ExpenseCategory("Educación", Icons.Filled.School),
    ExpenseCategory("Otros", Icons.Filled.Category)
)

fun categoryIcon(name: String): ImageVector =
    expenseCategories.find { it.name == name }?.icon ?: Icons.Filled.Category
