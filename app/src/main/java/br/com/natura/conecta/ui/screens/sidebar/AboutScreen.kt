package br.com.natura.conecta.ui.screens.sidebar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R

@Composable
fun AboutScreen() {
    Column(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(top = 50.dp, bottom = 100.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxSize(0.50f)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "App Conecta\n\nApp Desenvolvido pelos alunos do Grupo NEXUS do curso de sistemas de informação - FIAP\n\nO App foi desenvolvido utilizando a linguagem de programação Kotlin, e a tecnologia Jetpack Conpose, o kit de ferramentas moderno recomendado pelo Android para criar interfaces nativas. Ele simplifica e acelera o desenvolvimento de UI no Android.",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(0.80f)
            )
        }
    }
}

@Preview
@Composable
private fun AboutScreenPreview() {
    AboutScreen()
}