package com.example.unflowcarousel

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Carousel(screens: List<ScreenData>) {
    val activity = (LocalLifecycleOwner.current as ComponentActivity)
    val currentPage = remember { mutableStateOf(0) }
    val buttonLabel = if (currentPage.value < screens.size - 1) "Next" else "Check it out";

    Column {
        Screen(screens[currentPage.value])
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0E51FF)),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                if (currentPage.value == screens.size - 1) {
                    activity.finish()
                } else {
                    currentPage.value++
                }
            }
        ) {
            Text(
                text = buttonLabel, color = Color(0xFFFFFFFF), modifier = Modifier.padding(6.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                ),
            )
        }
    }
}

@Composable
fun Screen(screenData: ScreenData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            imageModel = screenData.imageHeader,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = screenData.title,
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.W700
            ),
            modifier = Modifier.padding(12.dp),
        )
        Text(
            text = screenData.description,
            style = TextStyle(
                fontSize = 20.sp,
            ),
            modifier = Modifier.padding(12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Carousel(listOf())
}