package com.example.jetpackcomposeexample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeexample.ui.theme.JetPackComposeExampleTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Composer 1", "¿estas preparado 1"),
    MyMessage("Hola Jetpack Composer 2", "¿estas preparado 2"),
    MyMessage("Hola Jetpack Composer 3", "¿estas preparado 3"),
    MyMessage("Hola Jetpack Composer 4", "¿estas preparado 4"),
    MyMessage("Hola Jetpack Composer 5", "¿estas preparado 5"),
    MyMessage("Hola Jetpack Composer 6", "¿estas preparado 6"),
    MyMessage("Hola Jetpack Composer 7", "¿estas preparado 7"),
    MyMessage("Hola Jetpack Composer 8", "¿estas preparado 8"),
    MyMessage("Hola Jetpack Composer 9", "¿estas preparado 9"),
    MyMessage("Hola Jetpack Composer 10", "¿estas preparado 10"),
    MyMessage("Hola Jetpack Composer 11", "¿estas preparado 11"),
    MyMessage("Hola Jetpack Composer 12", "¿estas preparado 12"),
    MyMessage("Hola Jetpack Composer 13", "¿estas preparado 13"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeExampleTheme() {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage (val title:String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn{
        items(messages){ message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
    )
}

@Composable
fun MyTexts(message: MyMessage){
    Column(modifier = Modifier.padding(8.dp)){
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2)
    }

}
@Composable
fun MyText(text: String, color: Color, style: TextStyle){
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    JetPackComposeExampleTheme {
            MyMessages(messages)
    }
}
