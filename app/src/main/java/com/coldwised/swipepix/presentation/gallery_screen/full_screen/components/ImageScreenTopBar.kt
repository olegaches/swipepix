package com.coldwised.swipepix.presentation.gallery_screen.full_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.coldwised.swipepix.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreenTopBar(
    isVisible: Boolean,
    title: String,
    onBackClicked: () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(
            animationSpec = tween(Constants.TOP_BAR_VISIBILITY_ENTRY_ANIMATION_TIME)
        ),
        exit = fadeOut(
            animationSpec = tween(Constants.TOP_BAR_VISIBILITY_EXIT_ANIMATION_TIME)
        )
    ) {
        val iconsDefault = Icons.Default
        val whiteColor = Color.White
        TopAppBar(
            title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodySmall
                    )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                titleContentColor = whiteColor,
                containerColor = Color.Black,
                navigationIconContentColor = whiteColor,
            ),
            navigationIcon = {
                IconButton(
                    onClick = onBackClicked
                ) {
                    Icon(
                        contentDescription = null,
                        imageVector = iconsDefault.ArrowBack
                    )
                }
            }
        )
    }
}