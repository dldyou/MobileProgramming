package com.example.eweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageListFactory

class ImageViewModel: ViewModel() {
    val _imageList = ImageListFactory.makeImageList().invoke()
    val imageList: MutableList<ImageData>
        get() = _imageList
}