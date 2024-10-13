package com.vashaacademy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.vashaacademy.components.LanguageSelection
import com.vashaacademy.R
import com.vashaacademy.components.ContactExpansionPannel
import com.vashaacademy.constants.Screen
import com.vashaacademy.viewmodels.LangViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreenWithDrawer(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    langViewModel: LangViewModel = viewModel()
) {

    val isEnglish by langViewModel.isEnglish.observeAsState()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 15.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    LanguageSelection()
                    ContactExpansionPannel()
                    ListItem(
                        leadingContent = { Icon(imageVector = Icons.Default.Info, contentDescription = "") },
                        headlineContent = { Text(text = if ( isEnglish!! ) "Frequently Asked Questions" else "সাধারণ জিজ্ঞাসা") },
                        modifier = Modifier.clickable {
                            navController?.navigate(Screen.Faq.route)
                        }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red.copy(0.89f),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = if ( isEnglish!! ) "Log Out" else "লগ আউট")
                    }
                }
            }
        }
    ) {
        HomeScreen(
            onMenu = {
                scope.launch { drawerState.open() }
            },
            navController = navController
        )
    }
}

@Preview
@Composable
private fun HomeScreenWithDrawerPrev() {
    HomeScreenWithDrawer()
}