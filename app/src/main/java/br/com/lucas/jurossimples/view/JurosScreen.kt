package br.com.lucas.jurossimples.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucas.jurossimples.components.CaixaDeEntrada
import br.com.lucas.jurossimples.model.calcularJuros
import br.com.lucas.jurossimples.model.calcularMontante

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    //var capital by remember { mutableStateOf("") }
    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")
    //var taxa by remember { mutableStateOf("") }
    val taxa by jurosScreenViewModel.taxa.observeAsState(initial = "")
    //var tempo by remember { mutableStateOf("") }
    val tempo by jurosScreenViewModel.tempo.observeAsState(initial = "")
    //var juros by remember { mutableDoubleStateOf(0.0) }
    val juros by jurosScreenViewModel.juros.observeAsState(initial = 0.0)
    //var montante by remember { mutableDoubleStateOf(0.0) }
    val montante by jurosScreenViewModel.montante.observeAsState(initial = 0.0)


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
                    CaixaDeEntrada(
                        value = taxa,
                        label = "Taxa de juros mensal",
                        modifier = Modifier.fillMaxWidth(),
                        placeHolder = "Qual a taxa de juros mensal?",
                        keyboardType = KeyboardType.Number,
                        onValueChange = { jurosScreenViewModel.onTaxaChanged(it) }
                    )
                    CaixaDeEntrada(
                        value = tempo,
                        label = "Periodo",
                        modifier = Modifier.fillMaxWidth(),
                        placeHolder = "Perido em meses",
                        keyboardType = KeyboardType.Number,
                        onValueChange = { jurosScreenViewModel.onTempoChanged(it) }
                    )
                    Button(
                        onClick = {
                            jurosScreenViewModel.calcularJurosViewModel()
                            jurosScreenViewModel.calcularMontanteViewModel()
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