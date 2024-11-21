package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)



@Composable
fun Input(modifier: Modifier = Modifier){
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }

    var dataOrigin by remember { mutableStateOf("") }
    var dataDeparture by remember { mutableStateOf("") }
    var dataArrival by remember { mutableStateOf("") }


    var TP by remember { mutableStateOf("") }
    var dataTP by remember { mutableStateOf("") }

    val dataTrp = listOf("Bus", "Ship","Train","Plane")



    Column (modifier = modifier.fillMaxSize()){


        Column (modifier = modifier.fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                contentAlignment = Alignment.Center
            )
            {
                Image(
                    painter = painterResource(R.drawable.foto),
                    modifier = Modifier.size(80.dp)
                        .clip(CircleShape),
                    contentDescription = null
                )

            }

            Column {

                Row(verticalAlignment = Alignment.CenterVertically){


                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                    Text("Muhamad Hilal", color = Color.Black)

                }
                Row(verticalAlignment = Alignment.CenterVertically){


                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp), // Sesuaikan ukuran ikon
                        tint = Color.Black

                    )
                    TampilData(
                        judul = "Origin",
                        isinya = dataOrigin
                    )

                }


            }
            Column  {
                Text(text = "Plan Your Adventures", fontWeight =
                FontWeight.Bold,
                    fontSize = 20.sp,
                )
                Text(text = "Let's plan an exquisite adventure",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.padding(5.dp))


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                shape = RoundedCornerShape(16.dp),
                value = origin,
                onValueChange = {origin = it},
                label = {
                    Text("Origin")
                },
                placeholder = {
                    Row(verticalAlignment = Alignment.CenterVertically) { // Gunakan Row untuk menempatkan ikon dan teks

                        Text("Origin")
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text )

            )


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                shape = RoundedCornerShape(16.dp),
                value = departure,
                onValueChange = { departure = it },
                label = {
                    Text("Departure")
                },
                placeholder = {
                    Row(verticalAlignment = Alignment.CenterVertically) { // Gunakan Row untuk menempatkan ikon dan teks

                        Text("Departure")
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )



            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                shape = RoundedCornerShape(16.dp),
                value = arrival,
                onValueChange = {arrival = it},
                label = {
                    Text("Arrival")
                },
                placeholder = {
                    Row(verticalAlignment = Alignment.CenterVertically) {


                        Text("Arrival")
                    }
                },
            )

            Card{
                Text(modifier = Modifier.padding(6.dp),text = "Choose Transportation", fontWeight =
                FontWeight.Bold,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center)

                Card(modifier = Modifier.background(color = Color(0xFF0A3C81))){
                    Row {
                        dataTrp.forEach { selectedTP ->
                            Row(verticalAlignment = Alignment.CenterVertically){
                                RadioButton(selected = TP == selectedTP,
                                    onClick = {
                                        TP = selectedTP
                                    })
                                Text(selectedTP)
                            }
                        }
                    }
                }
            }

            Button(onClick = {
                dataTP = TP
                dataOrigin = origin
                dataDeparture = departure
                dataArrival = arrival},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
            modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth()


            )

            {
                Text("Submit")
            }





            Card(modifier = Modifier.fillMaxWidth().padding(16.dp)
//                .background(color = Color(0xFF0A3C81))
            ){
                Column {
//
                    TampilData(
                        judul = "Origin",
                        isinya = dataOrigin
                    )
                    TampilData(
                        judul = "Departure",
                        isinya = dataDeparture
                    )
            }


            }
            Card(modifier = Modifier.fillMaxWidth().padding(16.dp)){
                TampilData(
                    judul = "Arrival",
                    isinya = dataArrival
                )
                TampilData(
                    judul = "Transport",
                    isinya = dataTP
                )
            }
        }

    }
}

@Composable
fun TampilData(
    judul:String,
    isinya:String
){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(judul, modifier = Modifier.weight(1.5f))
        Text(":", modifier = Modifier.weight(0.1f))
        Text(isinya,
            modifier = Modifier.weight(2f))
    }
}

//@Composable
//fun TampilanHeader(){
//    Box(modifier = Modifier
//        .fillMaxWidth()
//
//        .background(color = Color(0xFF0A3C81))
//        .padding(5.dp)
//    ){
//        Column  {
//
//            }
//
//            }
//}
