package com.example.unflowcarousel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Carousel(screens: List<ScreenData>) {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Carousel(listOf())
}