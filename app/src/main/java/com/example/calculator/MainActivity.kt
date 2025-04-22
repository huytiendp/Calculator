package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Surface {

                    Calculator(

                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var no1 by remember { mutableStateOf("") }
    var no2 by remember { mutableStateOf("") }
    var kq by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inverseOnSurface
    )
    {
        Column {
            Text("Calculator",
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
                )

            TextField(
                value = no1, onValueChange = { no1 = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )
            TextField(
                value = no2, onValueChange = { no2 = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            TextField(
                value = kq, onValueChange = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                label = { Text("Kết quả:") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Row {
                Button(
                    onClick = { kq = (no1.toDouble() + no2.toDouble()).toString() },
                    modifier = Modifier.padding(6.dp)
                )
                {

                    Text("+")
                }
                Button(
                    onClick = { kq = (no1.toDouble() - no2.toDouble()).toString() },
                    modifier = Modifier.padding(6.dp)
                )
                {
                    Text("-")
                }
                Button(
                    onClick = { kq = (no1.toDouble() * no2.toDouble()).toString() },
                    modifier = Modifier.padding(6.dp)
                )
                {
                    Text("*")
                }
                Button(onClick = { kq = (no1.toDouble() / no2.toDouble()).toString() },
                    modifier = Modifier.padding(6.dp)

                )
                {
                    Text("/")

                }
                Button(onClick = {
                    kq = ""
                    no1 = ""
                    no2 = ""
                },
                    modifier = Modifier.padding(6.dp)
                )
                {
                    Text("Del")

                }
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator( modifier = Modifier.padding(8.dp))
    }
}