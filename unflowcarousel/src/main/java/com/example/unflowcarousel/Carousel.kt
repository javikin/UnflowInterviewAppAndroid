package com.example.unflowcarousel

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Carousel(screens: List<ScreenData>) {
    val activity = (LocalLifecycleOwner.current as ComponentActivity)
    val currentPage = remember { mutableStateOf(0) }
    val buttonLabel = if (currentPage.value < screens.size - 1) "Next" else "Check it out";

    GlideImage(
        imageModel = screens[currentPage.value].imageBackground,
        contentScale = ContentScale.Crop,
    )

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Screen(screens[currentPage.value])
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
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

    BackHandler {
        if (currentPage.value > 0) {
            currentPage.value--
        } else {
            activity.finish()
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
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Text(
            text = screenData.title,
            style = TextStyle(
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.W700
            ),
            modifier = Modifier.padding(12.dp),
        )
        Text(
            text = screenData.description,
            style = TextStyle(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
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