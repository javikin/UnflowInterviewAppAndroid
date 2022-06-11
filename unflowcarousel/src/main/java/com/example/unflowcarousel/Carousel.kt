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
import androidx.compose.runtime.*
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
    val carouselState = remember { CarouselState() }

    GlideImage(
        imageModel = screens[carouselState.currentPage].imageBackground,
        contentScale = ContentScale.Crop,
    )
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Screen(screens[carouselState.currentPage])
        }
        FooterButton(carouselState, screens.size)
    }

    BackHandler {
        if (carouselState.currentPage > 0) {
            carouselState.currentPage--
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
            .verticalScroll(rememberScrollState()),
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

@Composable
fun FooterButton(carouselState: CarouselState, pages: Int) {
    val activity = (LocalLifecycleOwner.current as ComponentActivity)
    val buttonLabel = if (carouselState.currentPage < pages - 1) "Next" else "Check it out";
    Box(modifier = Modifier.padding(12.dp)) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0E51FF)),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                if (carouselState.currentPage == pages - 1) {
                    activity.finish()
                } else {
                    carouselState.currentPage++
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Carousel(listOf())
}

class CarouselState {
    var currentPage by mutableStateOf(0)
}