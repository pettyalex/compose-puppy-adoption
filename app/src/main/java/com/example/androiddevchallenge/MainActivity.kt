/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.services.Pupper
import com.example.androiddevchallenge.services.PuppySource
import com.example.androiddevchallenge.ui.theme.MyTheme

val TheDogs = listOf(
    Pupper("Frank", "3", "Male", "Pug", "A picture"),
    Pupper("Frank", "3", "Male", "Pug", "A picture"),
    Pupper("Frank", "3", "Male", "Pug", "A picture")
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") { DogList(navController) }
        composable("detail") { DogDetail(dog = PuppySource.GeneratePuppy()) }
    }
}

@Composable
fun DogList(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            TheDogs.map {
                DogListItem(dog = it, onClick = { navController.navigate("detail") })
            }
        }
    }
}

@Composable
fun DogListItem(
    dog: Pupper,
    onClick: () -> Unit
) {
    Card(
        elevation = 2.dp, backgroundColor = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clickable(onClick = onClick)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            DogCircle()
            Column {
                Text(
                    text = dog.name, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(text = dog.breed, modifier = Modifier.padding(5.dp))
            }
        }
    }
}

@Composable
fun DogDetail(dog: Pupper) {
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            Card {
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card {
                Column {
                    Text(fontWeight = FontWeight.ExtraBold, text = dog.name)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = dog.breed)
                    Text(text = dog.description)
                }
            }
        }
    }
}

@Composable
fun DogCircle() {
    return Canvas(
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawCircle(
            color = Color.Blue,
            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
            radius = size.minDimension / 3
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
