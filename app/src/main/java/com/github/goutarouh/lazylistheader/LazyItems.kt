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



fun LazyListScope.headerItem(scrollAmount: Int) {
    item {
        Row(
            Modifier
                .height(headerHeightDp)
                .fillMaxWidth()
                .border(width = 1.dp, shape = RoundedCornerShape(12.dp), color = Color.Gray)
            , horizontalArrangement = Arrangement.Center
            , verticalAlignment = Alignment.CenterVertically
        ) {}
    }
}


fun LazyListScope.lazyItems() {

    items(10) {
        Item("$it")
    }

}

@Composable
private fun Item(
    item: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(12.dp), color = Color.Gray)
            .padding(vertical = 128.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "item: $item")
    }
}