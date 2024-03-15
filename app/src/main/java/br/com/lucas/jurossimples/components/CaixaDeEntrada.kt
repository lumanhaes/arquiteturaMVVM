package br.com.lucas.jurossimples.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.LiveData

@Composable
fun CaixaDeEntrada(
    value: String,
    label: String,
    modifier: Modifier,
    placeHolder: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
    ) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(text = label)},
        placeholder = { Text(text = placeHolder)},
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )}