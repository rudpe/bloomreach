package com.example.bloomreach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bloomreach.ui.theme.BloomreachTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewmodel = hiltViewModel<MainViewModel>()
            BloomreachTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.fillMaxSize().padding(innerPadding).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceAround) {
                        ActionButton("Create input form") { viewmodel.createInputForm() }
                        ActionButton("Get form") { viewmodel.getForm() }
                        ActionButton("Edit form") { viewmodel.editForm() }
                        ActionButton("Submit form") { viewmodel.submitForm() }
                        ActionButton("Add input") { viewmodel.addInput() }
                        ActionButton("Edit input") { viewmodel.editInput() }
                        ActionButton("Delete input") { viewmodel.deleteInput() }
                        ActionButton("Change submit button label") { viewmodel.setSubmitButtonLabel() }
                        ActionButton("Change form font size") { viewmodel.setFormFontSize() }
                        ActionButton("Change text color") { viewmodel.setFontHexColor() }
                        ActionButton("Change background color") { viewmodel.setBackgroundHexColor() }
                        ActionButton("Change background image") { viewmodel.setBackgroundImage() }
                    }
                }
            }
        }
    }
}

@Composable
fun ActionButton(label: String, onClick: () -> Unit) {
    Button(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(), onClick = onClick) {
        Text(text = label)
    }
}