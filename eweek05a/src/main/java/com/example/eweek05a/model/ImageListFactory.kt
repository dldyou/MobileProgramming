package com.example.eweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.eweek05a.R

object ImageListFactory {
    fun makeImageList() = {
        mutableStateListOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img1),
                buttonType = ButtonType.ICON,
                likes = 50
            ),
            ImageData(
                image = ImageUri.ResImage(R.drawable.img2),
                buttonType = ButtonType.EMOJI,
                likes = 35,
                dislikes = 15
            ),
            ImageData(
                image = ImageUri.ResImage(R.drawable.img1),
                buttonType = ButtonType.EMOJI,
                likes = 35,
                dislikes = 15
            ),
            ImageData(
                image = ImageUri.ResImage(R.drawable.img2),
                buttonType = ButtonType.EMOJI,
                likes = 35,
                dislikes = 15
            ),
            ImageData(
                image = ImageUri.ResImage(R.drawable.img3),
                buttonType = ButtonType.ICON,
                likes = 20
            )
        )
    }
}