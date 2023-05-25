package com.example.examen.Lista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.examen.Navigation.Rutas
import com.example.examen.R

@Composable
fun ItemDetail(navController: NavController){
    TopAppBar(
        backgroundColor = Color.DarkGray,
    ) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Retroceder",
                tint = Color.White
            )
        }
        Text(
            text = "Detalle",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ITEM 1")
        Image(
            painter = painterResource(R.drawable.ic_baseline_report_24),
            contentDescription = "Image description",
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .size(100.dp)
        )
        Text(text = "descripcion: asnalsknfdalksnflknasflaslfknlaksfnlkasnflkasfnlkasnflkasnflkasnf")
        Text(text = "GRAVEDAD: LEVE")
        Text(text = "Registrado por: user asasd")
    }
}