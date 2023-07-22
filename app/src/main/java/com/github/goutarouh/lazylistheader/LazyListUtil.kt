package com.github.goutarouh.lazylistheader

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
@Composable
fun LazyListState.scrollAmount(): Int {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    var previousItemHeight by remember(this) { mutableStateOf(heightAtOrZero(firstVisibleItemIndex)) }
    var scrollAmount by remember(this) { mutableStateOf(0) }
    return remember(System.currentTimeMillis()) {
        mutableStateOf(
            if (previousIndex == firstVisibleItemIndex) {
                scrollAmount += firstVisibleItemScrollOffset - previousScrollOffset
                scrollAmount
            } else {
                if (previousIndex > firstVisibleItemIndex) {
                    val currentScroll = heightAtOrZero(firstVisibleItemIndex) - firstVisibleItemScrollOffset
                    scrollAmount += -previousScrollOffset - currentScroll
                } else {
                    val lastScroll = previousItemHeight - previousScrollOffset
                    scrollAmount += lastScroll + firstVisibleItemScrollOffset
                }
                scrollAmount
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
                previousItemHeight = heightAtOrZero(firstVisibleItemIndex)
            }
        )
    }.value
}

fun LazyListState.heightAtOrZero(index: Int): Int {
    return layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }?.size ?: 0
}