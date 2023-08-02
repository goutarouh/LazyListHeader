package com.github.goutarouh.lazylistheader

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


fun LazyListScope.randomLazyItems() {

    items(30) {
        Item(
            "$it",
            modifier = Modifier.padding(vertical = 8.dp).height(if (it % 2 == 0) 120.dp else 80.dp)
        )
    }
}

@Composable
private fun Item(
    item: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, shape = RoundedCornerShape(12.dp), color = Color.Gray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "item: $item")
    }
}