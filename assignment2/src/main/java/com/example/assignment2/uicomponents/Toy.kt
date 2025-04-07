package com.example.assignment2.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.R
import com.example.assignment2.model.ItemFactory

@Composable
fun Toy(checkList: MutableList<Boolean>, images: List<Int>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = null
        )

        for (i in 0 until checkList.size) {
            if (checkList[i]) {
                Image(
                    painter = painterResource(id = images[i]),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun ToyPreview() {
    Toy(ItemFactory.makeCheckList(), ItemFactory.makeImgList())
}