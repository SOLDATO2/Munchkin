package com.example.aula13

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaJogadores()
        }
    }
}



@Composable
fun TelaJogadores() {

    LazyColumn(modifier = Modifier.fillMaxSize().padding(5.dp)) {
        items(6) { jogador ->

            var nomeJgdr by remember { mutableStateOf("") }
            var level by remember { mutableStateOf(1) }
            var equipamento by remember { mutableStateOf(0) }
            var poder by remember { mutableStateOf(0) }
            var modificadores by remember { mutableStateOf(0) }

            poder = level + equipamento + modificadores



            Column(modifier = Modifier.padding(vertical = 10.dp)) {

                Text("Jogador ${jogador + 1}", modifier = Modifier.padding(vertical = 5.dp), style = TextStyle(fontSize = 25.sp))

                TextField(value = nomeJgdr, onValueChange = { nomeJgdr = it }, label = { Text("Jogador") }, modifier = Modifier.fillMaxWidth())
                //level
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = {
                        //"Limite o level para um mínimo de 1 e um máximo de 10 (limite para vitória no jogo)."
                        if (level > 1) {
                            level--
                        }

                    }) {
                        Text("-")
                    }
                    Text(text = "Level: ${level}", modifier = Modifier.align(Alignment.CenterVertically), style = TextStyle(fontSize = 20.sp))
                    Button(onClick = {

                        if (level < 10)
                        level++

                    }) {
                        Text("+")
                    }
                }

                //poder
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

                    Text(text = "Poder: ${poder}", modifier = Modifier.align(Alignment.CenterVertically), style = TextStyle(fontSize = 20.sp))

                }


                //equipamento
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = {

                        if(equipamento > 0){
                            equipamento--
                        }

                    }) {
                        Text("-")
                    }
                    Text(text = "Bonus Equipamento: ${equipamento}", modifier = Modifier.align(Alignment.CenterVertically), style = TextStyle(fontSize = 20.sp))
                    Button(onClick = {

                        if(equipamento < 99){
                            equipamento++
                        }

                    }) {
                        Text("+")
                    }
                }

                //modificadores
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

                    Button(onClick = {
                        if(modificadores > -10){
                            modificadores -= 1
                        }
                    }) {
                        Text("-")
                    }

                    Text(text = "Modificadores: ${modificadores}", modifier = Modifier.align(Alignment.CenterVertically), style = TextStyle(fontSize = 20.sp))

                    Button(onClick = {
                        if(modificadores < 10){
                            modificadores += 1
                        }
                    }) {
                        Text("-")
                    }

                }

            }
            Text("----------------------------------------------------------------------", modifier = Modifier.padding(vertical = 5.dp), style = TextStyle(fontSize = 20.sp))
        }
    }


}