package br.com.lucas.jurossimples.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucas.jurossimples.model.calcularJuros
import br.com.lucas.jurossimples.model.calcularMontante
import br.com.lucas.jurossimples.components.CaixaDeEntrada

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    //var capital by remember { mutableStateOf("") }
    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")

    var taxa by remember { mutableStateOf("") }
    var tempo by remember { mutableStateOf("") }
    var juros by remember { mutableDoubleStateOf(0.0) }
    var montante by remember { mutableDoubleStateOf(0.0) }

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )
                    // Caixas de entrada da aplicação
                    CaixaDeEntrada(
                        value = capital,
                        label = "Valor do invetimento",
                        modifier = Modifier.fillMaxWidth(),
                        placeHolder = "Quanto deseja investir",
                        keyboardType = KeyboardType.Number,
                        onValueChange = { jurosScreenViewModel.onCapitalChanged(it)}
                    )
                    OutlinedTextField(
                        value = taxa,
                        onValueChange = { taxa = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        placeholder = {
                            Text(text = "Qual a taxa de juros mensal?")
                        },
                        label = {
                            Text(text = "Taxa de juros mensal")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                    OutlinedTextField(
                        value = tempo,
                        onValueChange = { tempo = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        placeholder = {
                            Text(text = "Qual o tempo em meses?")
                        },
                        label = {
                            Text(text = "Período em meses")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                    Button(
                        onClick = {
                            juros = calcularJuros(
                                capital = capital.toDouble(),
                                taxa = taxa.toDouble(),
                                tempo = tempo.toDouble()
                            )
                            montante = calcularMontante(
                                capital = capital.toDouble(),
                                juros = juros
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "CALCULAR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Resultado da aplicação
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {
                Column(
                    modifier = Modifier
                        //.fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Resultado",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Juros",
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = juros.toString(),
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Montante",
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = montante.toString(),
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}