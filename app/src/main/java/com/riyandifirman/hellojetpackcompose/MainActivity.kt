package com.riyandifirman.hellojetpackcompose

import android.os.Bundle
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.H
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.riyandifirman.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

private val sampleName = listOf(
    "Andre",
    "Desta",
    "Parto",
    "Wendy",
    "Komeng",
    "Raffi Ahmad",
    "Andhika Pratama",
    "Vincent Ryan Rompies"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloJetpackComposeTheme {
                HelloJetpackComposeApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isExpanded by remember { mutableStateOf(false)}

    Row (
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.jetpack_compose),
            contentDescription = "Logo Jetpack Compose",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Hello $name!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "Welcome to Dicoding!")
        }
        IconButton(onClick = { isExpanded = !isExpanded }) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                contentDescription = if (isExpanded) "Show less" else "Show more"
            )
        }
    }
}

@Composable
fun HelloJetpackComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        GreetingList(sampleName)
    }
}

@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
        Column {
            for (name in names) {
                Greeting(name)
            }
        }
    } else {
        Text("No people to great :(")
    }
}

@Preview(showBackground = true, device = Devices .PIXEL_4)
@Composable
fun HelloJetpackComposeAppPreview() {
    HelloJetpackComposeTheme {
        HelloJetpackComposeApp()
    }
}