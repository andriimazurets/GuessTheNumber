package com.mazurets.guessthenumber.Layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    var countScore by remember { mutableStateOf(0) }
    val options = listOf("1","2","3","4","5","6")
    var selectedOption by remember { mutableStateOf("0") }
    var result by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Score: $countScore",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        HomeMainText()

        Column (modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            options.forEach{
                    option ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    RadioButton(
                        selected = option == selectedOption,
                        onClick = { selectedOption = option },
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = option,
                        fontSize = 24.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = "The number dropped: $result", fontSize = 32.sp)
            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = "You choice: ${selectedOption.toInt()}", fontSize = 32.sp)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {
                result = (Math.random() * options.size).toInt() + 1
                if(result == selectedOption.toInt())
                    countScore += 10
            }, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text("Drop",
                    fontSize = 32.sp,
                    fontFamily = FontFamily.Serif)
            }
        }
    }
}

@Composable
fun HomeMainText(){
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            Text(text = "Guess the number",
                fontSize = 28.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


