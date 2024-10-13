package com.vashaacademy.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    screen:MutableIntState = mutableIntStateOf(0)
) {

    var selectedScreen by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ){
        NavigationBarItem(
            onClick = {
                screen.intValue = 0
            },
            label = { Text("UBT Exams") },
            icon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "") },
            selected = screen.intValue == 0,
            colors = NavigationBarItemDefaults.colors(
                unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f),
                unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f),
                selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                selectedIconColor = MaterialTheme.colorScheme.primary
            )
        )

        NavigationBarItem(
            onClick = {
                screen.intValue = 1
            },
            label = { Text("Notices") },
            icon = { Icon(imageVector = Icons.Default.Notifications, contentDescription = "") },
            selected = screen.intValue == 1,
            colors = NavigationBarItemDefaults.colors(
                unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f),
                unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f),
                selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                selectedIconColor = MaterialTheme.colorScheme.primary
            )
        )

        NavigationBarItem(
            onClick = {
                screen.intValue = 2
            },
            label = { Text("PDF books") },
            icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            selected = screen.intValue == 2,
            colors = NavigationBarItemDefaults.colors(
                unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f),
                unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f),
                selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                selectedIconColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}


@Composable
@Preview
fun BottomNavBarPrev(modifier: Modifier = Modifier) {
    BottomNavBar()
}