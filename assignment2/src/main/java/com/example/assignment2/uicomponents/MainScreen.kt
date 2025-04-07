package com.example.assignment2.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.model.ItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val checkList = rememberSaveable(
        saver = listSaver(
            save = { it -> it.toList() },
            restore = { it -> it.toMutableStateList() }
        )
    ) {
        ItemFactory.makeCheckList().toMutableStateList()
    }
    val images: List<Int> = ItemFactory.makeImgList()

    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier.then(modifier).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                Text(text = "202211328 윤찬규")
                Toy(checkList, images)
            }
            CheckList(checkList, images)
        }
    } else {
        Row(
            modifier = Modifier.then(modifier).fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Text(text = "202211328 윤찬규")
                Toy(checkList, images)
            }
            CheckList(checkList, images)
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}