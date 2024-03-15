package br.com.lucas.jurossimples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.lucas.jurossimples.ui.theme.JurosSimplesTheme
import br.com.lucas.jurossimples.view.JurosScreen
import br.com.lucas.jurossimples.view.JurosScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JurosSimplesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JurosScreen(jurosScreenViewModel = JurosScreenViewModel())
                }
            }
        }
    }
}