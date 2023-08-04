package com.github.goutarouh.lazylistheader

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
fun LazyListState.headerPosition(headerHeightPx: Int): Int {
    var previousIndex = remember(this) { firstVisibleItemIndex }
    var previousScrollOffset = remember(this) { firstVisibleItemScrollOffset }
    var previousItemHeight = remember(this) { heightAtOrZero(firstVisibleItemIndex) }
    var scrollAmount = remember(this) { 0 }
    return remember(this) {
        derivedStateOf {
            scrollAmount += if (previousIndex == firstVisibleItemIndex) {
                firstVisibleItemScrollOffset - previousScrollOffset
            } else {
                if (previousIndex > firstVisibleItemIndex) {
                    val currentScroll = heightAtOrZero(firstVisibleItemIndex) - firstVisibleItemScrollOffset
                    -previousScrollOffset - currentScroll
                } else {
                    val lastScroll = previousItemHeight - previousScrollOffset
                    lastScroll + firstVisibleItemScrollOffset
                }
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
                previousItemHeight = heightAtOrZero(firstVisibleItemIndex)
            }
            scrollAmount = scrollAmount.coerceIn(0, headerHeightPx)
            scrollAmount
        }
    }.value
}


fun LazyListState.heightAtOrZero(index: Int): Int {
    return layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }?.size ?: 0
}