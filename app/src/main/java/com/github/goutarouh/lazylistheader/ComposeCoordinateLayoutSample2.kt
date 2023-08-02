package com.github.goutarouh.lazylistheader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset

@Composable
fun ComposeCoordinateLayoutSample2() {
    val lazyState = rememberLazyListState()
    val density = LocalDensity.current
    val headerHeightPx = with(density) { headerHeightDp.toPx() }
    val headerPosition = lazyState.headerPosition(headerHeightPx.toInt())

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = lazyState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = headerHeightDp)
        ) {
            randomLazyItems()
        }
        Row(
            Modifier
                .offset { IntOffset(0, -headerPosition) }
                .height(headerHeightDp)
                .fillMaxWidth()
                .background(Color(0xFFEEEEEE))
            , horizontalArrangement = Arrangement.Center
            , verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "HEADER")
        }
    }
}