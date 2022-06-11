package com.example.unflowinterviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unflowcarousel.Carousel
import com.example.unflowcarousel.ScreenData
import com.example.unflowinterviewapp.ui.theme.UnflowInterviewAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
private fun MyApp() {
    UnflowInterviewAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Carousel(
                listOf(
                    ScreenData(
                        "https://i.postimg.cc/R0XmLW4r/onboarding-template-img1.png",
                        "Introducing Audio Rooms",
                        "We all know video calls can get tiring, so we’ve introduced a new form of room, just for audio.",
                    "https://i.postimg.cc/7YFZ5JYm/onboarding-template-bg1.png"
                    ),
                    ScreenData(
                        "https://i.postimg.cc/2yCXcww2/onboarding-template-img2.png",
                        "Smart Noise Cancellation",
                        "Whether it’s the builders or a very vocal puppy — we’ve built in smart noise cancellation to keep your stream zen.",
                        "https://i.postimg.cc/W14cb20X/onboarding-template-bg2.png"
                    ),
                    ScreenData(
                        "https://i.postimg.cc/YCTDKkR4/onboarding-template-img3.png",
                        "Boogie Mode",
                        "Use Audio Rooms for fun activities like socials. Turn on Boogie Mode to listen and react to music together — sounds good, right?",
                        "https://i.postimg.cc/XYqt6s0P/onboarding-template-bg3.png"
                    ),
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}