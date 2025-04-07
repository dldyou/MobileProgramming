package com.example.assignment2.model

import androidx.compose.runtime.mutableStateListOf
import com.example.assignment2.R

object ItemFactory {
    fun makeCheckList() = mutableStateListOf<Boolean>().apply { repeat(10) { add(true) } }
    fun makeImgList() = listOf(
        R.drawable.arms,
        R.drawable.eyebrows,
        R.drawable.glasses,
        R.drawable.mouth,
        R.drawable.nose,
        R.drawable.ears,
        R.drawable.eyes,
        R.drawable.hat,
        R.drawable.mustache,
        R.drawable.shoes
    )
}