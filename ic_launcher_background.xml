package com.oneui.expensetracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.oneui.expensetracker.R
import com.oneui.expensetracker.data.Expense
import com.oneui.expensetracker.data.categoryIcon
import com.oneui.expensetracker.viewmodel.ExpenseViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseListScreen(
    viewModel: ExpenseViewModel,
    onAddClick: () -> Unit
) {
    val expenses by viewModel.expenses.collectAsState()
    val total = expenses.sumOf { it.amount }
    val currencyFormat = remember { NumberFormat.getCurrencyInstance(Locale("es", "AR")) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                shape = RoundedCornerShape(20.dp),
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar gasto")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            contentPadding = PaddingValues(top = 24.dp, bottom = 100.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                TotalCard(total = total, formatter = currencyFormat)
                Spacer(modifier = Modifier.height(24.dp))
            }

            if (expenses.isEmpty()) {
                item { EmptyState() }
            } else {
                items(expenses, key = { it.id }) { expense ->
                    ExpenseRow(
                        expense = expense,
                        formatter = currencyFormat,
                        onDelete = { viewModel.deleteExpense(expense) }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
private fun TotalCard(total: Double, formatter: NumberFormat) {
    Surface(
        shape = RoundedCornerShape(28.dp),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Gasto total",
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = formatter.format(total),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Composable
private fun ExpenseRow(
    expense: Expense,
    formatter: NumberFormat,
    onDelete: () -> Unit
) {
    val dateFormat = remember { SimpleDateFormat("dd MMM, HH:mm", Locale("es", "AR")) }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = categoryIcon(expense.category),
                        contentDescription = expense.category,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = expense.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${expense.category} • ${dateFormat.format(Date(expense.date))}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = formatter.format(expense.amount),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onDelete, modifier = Modifier.size(28.dp)) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = "Eliminar",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyState() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Todavía no registraste gastos",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tocá el botón + para agregar el primero",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
