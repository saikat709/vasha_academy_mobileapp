package com.vashaacademy.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.vashaacademy.backend.Api
import com.vashaacademy.backend.Notice
import com.vashaacademy.backend.PdfBook

@Composable
fun NoticePartialScreen(modifier: Modifier = Modifier) {
    var currentTab by remember { mutableIntStateOf(0) }
    val noticeTabs = listOf("Other Country", "Bangladesh")
    val context = LocalContext.current

    var currentNotices: List<Notice>? by remember { mutableStateOf(null) }
    var notices: List<Notice>? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        val res = Api.getInstance().getNotices()
        if(res.isSuccess){
            notices = res.getOrNull()
        }else{
            notices = null
        }
        Log.d("saikat", "####" + notices.toString())
        currentNotices = notices?.filter { it.country != "bd" }
    }

    LaunchedEffect(currentTab) {
        if (currentTab == 0){
            currentNotices = notices?.filter { it.country != "bd" }
        }else{
            currentNotices = notices?.filter { it.country == "bd" }
        }
    }

    Column(
        modifier = Modifier.then(modifier)
    ){
        TabRow(
            selectedTabIndex = currentTab,
        ) {
            noticeTabs.forEachIndexed { index, title ->
                Tab(
                    selected = currentTab == index,
                    onClick = {currentTab = index},
                    text = { Text(title) }
                )
            }
        }
        LazyColumn {
            currentNotices?.size?.let {
                items(it){
                    val notice = notices!![it]
                    ListItem(
                        headlineContent = { Text(notice.text) },
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse(notice.link)
                            }
                            context.startActivity(intent)
                        },
                        trailingContent = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Aroow."
                            )
                        }
                    )
                }
            }

        }
        if (currentNotices == null){
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Text("To notice found.",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }


}


@Preview
@Composable
private fun NoticePartialScreenPrview() {
    NoticePartialScreen()
}
