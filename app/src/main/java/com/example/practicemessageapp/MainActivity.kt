package com.example.practicemessageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicemessageapp.ui.theme.PracticeMessageAppTheme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeMessageAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// modifier:装飾
// 画面表示形式を定義している
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // remember:変数の状態を常に保持する(Next.js の useState と似ている)
    val hello = remember { mutableStateOf("こんにちは") }
    val context = LocalContext.current
    // 縦に並べて表示する
    Column(
        modifier = modifier
    ) {
        // 文字を画面に表示する
        Text(
//            text = "こんにちは $name!",
            text = "${hello.value} $name!",
            fontSize = 32.sp, // 大きさを変える
            color = Color.Red, // 色を変える
//        modifier = modifier,
        )
        Button(onClick = {
            hello.value = "こんばんは"
        }) {
            Text("夜")
        }
        Button(onClick = {
            hello.value = "おはよう"
            Toast.makeText(context, "変更しました", Toast.LENGTH_SHORT).show() // 下から表示されるメッセージ
        }) {
            Text("朝")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeMessageAppTheme {
        Greeting("Android")
    }
}