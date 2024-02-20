package com.example.uppgift2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uppgift2.ui.theme.Uppgift2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uppgift2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    twoBut()
                }
            }
        }
    }
}

@Composable
fun twoBut() {

    var addXY by remember {
        mutableStateOf(listOf<String>())
    }


    Column(modifier = Modifier
        .fillMaxWidth()
        ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(onClick = {
                addXY = addXY + "X"
            },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue
                )
                ) {
                Text("X")
            }

            Button(onClick = {
                addXY = addXY + "Y"
            },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue,

                )
                ) {
                Text("Y")
            }
        }
        LazyColumn {
            items(addXY) { item ->
                Text(
                    text = item,
                    fontSize = 24.sp
                )


            }
        }

        Button(onClick = {
            addXY = emptyList()
        },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
            )
            ) {
            Text("Reset")

        }


    }

}


@Preview(showBackground = true)
@Composable
fun TwoButPreview() {
    Uppgift2Theme {
        twoBut()
    }
}