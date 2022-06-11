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
import com.example.unflowcarousel.*
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
                        imageHeader = "https://i.postimg.cc/R0XmLW4r/onboarding-template-img1.png",
                        imageBackground = "https://i.postimg.cc/7YFZ5JYm/onboarding-template-bg1.png",
                        blocks = listOf(
                            Block(
                                0,
                                "Introducing Audio Rooms",
                                mapOf("text_style" to BlockTextStyle.LG.style),
                                BlockType.TEXT
                            ),
                            Block(
                                1,
                                "We all know video calls can get tiring, so we’ve introduced a new form of room, just for audio.",
                                mapOf(),
                                BlockType.TEXT
                            )
                        )
                    ),

                    ScreenData(
                        imageHeader = "https://i.postimg.cc/2yCXcww2/onboarding-template-img2.png",
                        imageBackground = "https://i.postimg.cc/W14cb20X/onboarding-template-bg2.png",
                        blocks = listOf(
                            Block(
                                0,
                                "Smart Noise Cancellation",
                                mapOf("text_style" to BlockTextStyle.LG.style),
                                BlockType.TEXT
                            ),
                            Block(
                                1,
                                "Whether it’s the builders or a very vocal puppy — we’ve built in smart noise cancellation to keep your stream zen.",
                                mapOf(),
                                BlockType.TEXT
                            )
                        )
                    ),

                    ScreenData(
                        imageHeader = "https://i.postimg.cc/YCTDKkR4/onboarding-template-img3.png",
                        imageBackground = "https://i.postimg.cc/XYqt6s0P/onboarding-template-bg3.png",
                        blocks = listOf(
                            Block(
                                0,
                                "Boogie Mode",
                                mapOf("text_style" to BlockTextStyle.LG.style),
                                BlockType.TEXT
                            ),
                            Block(
                                1,
                                "Use Audio Rooms for fun activities like socials. Turn on Boogie Mode to listen and react to music together — sounds good, right?",
                                mapOf(),
                                BlockType.TEXT
                            )
                        )
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