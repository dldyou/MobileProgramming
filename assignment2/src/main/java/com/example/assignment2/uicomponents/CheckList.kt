package com.example.assignment2.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.R
import com.example.assignment2.model.ItemFactory

@Composable
fun CheckList(
    checkList: MutableList<Boolean>,
    images: List<Int>,
    modifier: Modifier = Modifier
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    Row {
        val halfSize = checkList.size / 2
        Column {
            for (i in 0 until halfSize) {
                Checkbox(
                    name = context.resources.getResourceEntryName(images[i]),
                    checked = checkList[i],
                    onCheckedChange = { checkList[i] = it },
                    modifier = modifier
                )
            }
        }
        Column {
            for (i in halfSize until checkList.size) {
                Checkbox(
                    name = context.resources.getResourceEntryName(images[i]),
                    checked = checkList[i],
                    onCheckedChange = { checkList[i] = it },
                    modifier = modifier
                )
            }
        }
    }
}

@Preview
@Composable
private fun CheckListPreview() {
    CheckList(ItemFactory.makeCheckList(), ItemFactory.makeImgList())
}