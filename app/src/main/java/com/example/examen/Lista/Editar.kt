package com.example.examen.Lista

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.examen.R

@Composable
fun Editar (navController: NavController){
    val lifecycleOwner = LocalLifecycleOwner.current
    val title = remember { mutableStateOf("")}
    val description = remember { mutableStateOf("") }
    val capturedImage = remember { mutableStateOf<Bitmap?>(null) }
    val imageUri = remember { mutableStateOf("") }
    val showError = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_baseline_report_24),
            contentDescription = "Image description",
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .size(200.dp)
        )
        CommonTextField(
            title = "Titulo",
            placeholder = "Bache en...",
            text = title.value,
            onValueChange = { title.value = it }
        )

        CommonTextField(
            title = "Descripción",
            placeholder = "En la av...",
            text = description.value,
            onValueChange = { description.value = it }
        )

        if (showError.value) {
            Text(
                text = "Por favor, complete los campos",
                textAlign = TextAlign.Center,
                color = Color.Red,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        Row( Modifier.padding(top = 10.dp)) {
            CommonButton(text = "Guardar", onClick = {

            })
            Spacer(modifier = Modifier.width(20.dp))
            CommonButton(text = "Cancelar", onClick = { navController.popBackStack() })
        }
    }
}
fun validateForm(title: String, description: String, bitmap: Bitmap?): Boolean {
    return title.isNotEmpty() && description.isNotEmpty() && bitmap != null
}
class TextFieldState(){
    var text: String by mutableStateOf("")
}


@Composable
fun dropDownMenu(blood : TextFieldState = remember { TextFieldState() }) {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Leve", "Moderada", "Fuerte")
    var textfieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column () {
        OutlinedTextField(
            value = blood.text,
            readOnly = true,
            onValueChange = { blood.text = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text("Gravedad")},
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "contentDescription",
                    Modifier.clickable { expanded = !expanded }
                )
            }

        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    blood.text = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}