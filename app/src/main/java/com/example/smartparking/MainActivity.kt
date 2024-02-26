package com.example.smartparking

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartparking.ui.theme.SmartParkingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartParkingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    ParkingLotCanvas()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartParkingTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun ParkingLotCanvas() {
    Column(modifier = Modifier
        .fillMaxSize()) {
        Text(text = "Smart Parking",
            color = Color(0xFF465775),
            fontSize = 45.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Canvas(modifier = Modifier
            .fillMaxSize()){
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawLine(
                start = Offset(x = 200f, y = canvasHeight/4f ),
                end = Offset(x = canvasWidth-80f, y = canvasHeight/4f),
                color = Color.Black,
                strokeWidth = 15f
            )
            drawLine(
                start = Offset(x = 200f, y = canvasHeight-600f ),
                end = Offset(x = canvasWidth-80f, y = canvasHeight-600f),
                color = Color.Black,
                strokeWidth = 15f
            )

            val spacing = 200f

            for(row in 0..6){
                val spaced = row * spacing

                drawLine(
                    start = Offset(x = 200f+spaced, y = 200f),
                    end = Offset(x = 200f+spaced, y = 950f),
                    color = Color.Black,
                    strokeWidth = 15f
                )

                drawLine(
                    start = Offset(x = 200f+spaced, y = 1300f),
                    end = Offset(x = 200f+spaced, y = canvasHeight-200f),
                    color = Color.Black,
                    strokeWidth = 15f
                )
            }


        }
    }

}