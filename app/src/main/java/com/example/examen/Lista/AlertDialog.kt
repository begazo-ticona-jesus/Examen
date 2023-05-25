package com.example.examen.Lista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.examen.R

@Composable
fun Dialog(navController: NavController){
    val showDialog = remember{ mutableStateOf(false) }
    AlertDialog(
        onDismissRequest = { showDialog.value = false },
        text = {
            Row (
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(R.drawable.ic_baseline_report_24),
                    contentDescription = "Image description",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(50.dp)
                )
                Text(
                    text = "¿Está seguro que quiere eliminar el reporte?",
                    style = TextStyle(
                        fontSize = 20.sp,
                    )
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { showDialog.value = false },
                //modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = "Confirmar")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    showDialog.value = false
                    navController.popBackStack()
                },
                //modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = "Cancelar")
            }
        }
    )
}