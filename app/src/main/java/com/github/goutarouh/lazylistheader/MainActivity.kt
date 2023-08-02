package com.github.goutarouh.lazylistheader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.goutarouh.lazylistheader.scrollable.ComposeCoordinateLayoutSample1
import com.github.goutarouh.lazylistheader.ui.theme.LazyListHeaderTheme

val headerHeightDp = 56.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListHeaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeCoordinateLayoutSample1()
                    //ComposeCoordinateLayoutSample2()
                }
            }
        }
    }
}
