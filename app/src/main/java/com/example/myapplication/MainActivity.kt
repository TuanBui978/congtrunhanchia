package com.example.myapplication

import android.graphics.Outline
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        var aValue by remember {
            mutableStateOf("")
        }
        var bValue by remember {
            mutableStateOf("")
        }
        var result = remember {
            mutableStateListOf<Float>()
        }
        Row {
            OutlinedTextField(value = aValue, modifier = Modifier.fillMaxWidth(), onValueChange = {
                value->
                aValue = value
            }, label = {Text(text = "Nhap a")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        Row {
            OutlinedTextField(value = bValue, modifier = Modifier.fillMaxWidth(), onValueChange = {
                    value->
                bValue = value
            }, label = {Text(text = "Nhap b")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)){
            Button(onClick = {
                val a = aValue.toFloat()
                val b = bValue.toFloat()
                result.add(0, a + b)
            }) {
                Text(text = "Cộng")
            }
            Button(onClick = {
                val a = aValue.toFloat()
                val b = bValue.toFloat()
                result.add(0, a - b)
            }) {
                Text(text = " Trừ ")
            }
            Button(onClick = {
                val a = aValue.toFloat()
                val b = bValue.toFloat()
                result.add(0, a * b)
            }) {
                Text(text = "Nhân")
            }
            Button(onClick = {
                val a = aValue.toFloat()
                val b = bValue.toFloat()
                result.add(0, a / b)
            }) {
                Text(text = "Chia")
            }
        }
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)) {
            result.forEach {
                it ->
                item {
                    Text(text = it.toString(), modifier = Modifier.fillMaxWidth(). padding(5.dp))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}