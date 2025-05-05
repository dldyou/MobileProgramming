package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.R
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageUri
import com.example.eweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val listState = rememberLazyListState()
//    var scrollState = rememberScrollState()

    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }
    // 세로
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//        Column(
//            modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            ImageList(imageList = imageList)
//        }
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(imageList) { index, imageData ->
                when(imageData.buttonType) {
                    ButtonType.ICON -> {
                        ImageWithButton(
                            image = imageData.image,
                            modifier = modifier
                        ) {
                            ButtonWithIcon(
                                likes = imageData.likes,
                                onClick = {
                                    imageList[index] = imageData.copy(
                                        likes = imageData.likes + 1
                                    )
                                }
                            )
                        }
                    }
                    ButtonType.BADGE -> {
                        ImageWithButton(
                            image = imageData.image,
                            modifier = modifier
                        ) {
                            ButtonWithBadge(
                                likes = imageData.likes,
                                onClick = {
                                    imageList[index] = imageData.copy(
                                        likes = imageData.likes + 1
                                    )
                                }
                            )
                        }
                    }
                    ButtonType.EMOJI -> {
                        ImageWithButton(
                            image = imageData.image,
                            modifier = modifier
                        ) {
                            ButtonWithEmoji(
                                likes = imageData.likes,
                                dislikes = imageData.dislikes,
                                onClickLikes = {
                                    imageList[index] = imageData.copy(
                                        likes = imageData.likes + 1
                                    )
                                },
                                onClickDisLikes = {
                                    imageList[index] = imageData.copy(
                                        dislikes = imageData.dislikes + 1
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    } else {
//        Row(
//            modifier = Modifier.fillMaxHeight().horizontalScroll(scrollState),
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            ImageList(imageList = imageList)
//        }
        LazyRow(
            state = listState,
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(imageList) { index, imageData ->
                when(imageData.buttonType) {
                    ButtonType.ICON -> {
                        ImageWithButton(
                            image = imageData.image,
                            modifier = modifier
                        ) {
                            ButtonWithIcon(
                                likes = imageData.likes,
                                onClick = {
                                    imageList[index] = imageData.copy(
                                        likes = imageData.likes + 1
                                    )
                                }
                            )
                        }
                    }
                    ButtonType.BADGE -> {
                        ImageWithButton(
                            image = imageData.image,
                            modifier = modifier
                        ) {
                            ButtonWithBadge(
                                likes = imageData.likes,
                                onClick = {
                                    imageList[index] = imageData.copy(
                                        likes = imageData.likes + 1
                                    )
                                }
                            )
                        }
                    }
                    ButtonType.EMOJI -> {
                        ImageWithButton(
                            image = imageData.image,
                            modifier = modifier
                        ) {
                            ButtonWithEmoji(
                                likes = imageData.likes,
                                dislikes = imageData.dislikes,
                                onClickLikes = {
                                    imageList[index] = imageData.copy(
                                        likes = imageData.likes + 1
                                    )
                                },
                                onClickDisLikes = {
                                    imageList[index] = imageData.copy(
                                        dislikes = imageData.dislikes + 1
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    AnimatedVisibility(visible = showButton) {
        ScrollToTopButton {
            scope.launch {
                state.scrollToItem(0)
            }
        }
    }

//    var img1State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.ICON,
//                likes = 50
//            )
//        )
//    }
//    // img2로 이모티콘
//    var img2State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 35,
//                dislikes = 15
//            )
//        )
//    }
//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                img1State = img1State.copy(
//                    likes = img1State.likes + 1
//                )
//            }
//        }
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(
//                        likes = img2State.likes + 1
//                    )
//                },
//                onClickDisLikes = {
//                    img2State = img2State.copy(
//                        dislikes = img2State.dislikes + 1
//                    )
//                }
//            )
//        }
//    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}