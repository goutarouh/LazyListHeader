package com.github.goutarouh.lazylistheader.scrollable

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import com.github.goutarouh.lazylistheader.headerHeightDp
import com.github.goutarouh.lazylistheader.lazyItems
import kotlinx.coroutines.launch

@Composable
fun ComposeCoordinateLayoutSample() {
    val lazyState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    var headerPositionPx by remember { mutableStateOf(0) }
    val density = LocalDensity.current
    val headerHeightPx = with(density) { headerHeightDp.toPx() }.toInt()
    val scrollableState = rememberScrollableState(consumeScrollDelta = {
        scope.launch { lazyState.scrollBy(-it) }
        headerPositionPx = (headerPositionPx + it.toInt()).coerceIn(-headerHeightPx, 0)
        it
    })

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(
                    orientation = Orientation.Vertical,
                    state = scrollableState
                ),
            contentPadding = PaddingValues(top = headerHeightDp),
            state = lazyState,
            userScrollEnabled = false
        ) {
            lazyItems()
        }
        Row(
            Modifier
                .offset { IntOffset(0, headerPositionPx) }
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