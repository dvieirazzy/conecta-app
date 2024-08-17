package br.com.natura.conecta.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.ConectaTheme
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.Orange
import br.com.natura.conecta.ui.theme.SoftOrange

@Composable
fun LoginScreen(onEnterClick: (String) -> Unit = {}) {
    val context = LocalContext.current
    var passwordVisible by remember { mutableStateOf(false) }
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val fieldsModifier = Modifier
        .padding(vertical = 20.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(15.dp))
        .focusRequester(focusRequester)
    val fieldsColors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        cursorColor = DarkOrange,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        selectionColors = TextSelectionColors(
            handleColor = SoftOrange,
            backgroundColor = Color.Transparent
        )
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE30F43), Color(0xFFEB661B)
                    )
                )
            )
            .padding(horizontal = 40.dp, vertical = 20.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            }
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.natura_logo),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(0.80f)
        )
        TextField(
            value = user,
            onValueChange = {
                user = it
            },
            modifier = fieldsModifier,
            placeholder = {
                Text(
                    text = "Insira seu CPF, E-mail ou Código",
                    color = DarkGray,
                    fontSize = 15.sp
                )
            },
            colors = fieldsColors,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = null,
                    tint = DarkOrange,
                    modifier = Modifier.size(30.dp)
                )
            },
            textStyle = TextStyle.Default.copy(
                fontSize = 15.sp
            ),
            singleLine = true
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = fieldsModifier,
            placeholder = {
                Text(
                    text = "Insira sua senha",
                    color = DarkGray,
                    fontSize = 15.sp
                )
            },
            colors = fieldsColors,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_key),
                    contentDescription = null,
                    tint = DarkOrange,
                    modifier = Modifier.size(30.dp)
                )
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.ic_eye_closed)
                else
                    painterResource(id = R.drawable.ic_eye_open)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = image,
                        contentDescription = null,
                        tint = DarkOrange,
                        modifier = Modifier.size(30.dp)
                    )
                }
            },
            textStyle = TextStyle.Default.copy(
                fontSize = 15.sp
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )
        Row(
            Modifier
                .padding(top = 90.dp, bottom = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = !rememberMe },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.White,
                        checkedColor = Color.White,
                        checkmarkColor = DarkOrange,
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(15.dp)
                )
                Text(
                    text = "Lembrar-me",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
            Text(
                text = "Esqueci minha senha",
                color = Color.White,
                fontSize = 14.sp,
                style = TextStyle(
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.clickable { }
            )
        }
        Button(
            onClick = {
                if (user == "helena@gmail.com" && password == "helena123")
                    onEnterClick(user)
                else
                    Toast.makeText(context, "Login e/ou senha inválido(s)", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(bottom = 100.dp)
                .fillMaxWidth()
                .height(50.dp),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        )
        {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Entrar",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 15.dp),
                    color = Orange
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = {

            },
            Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text = "Primeiro Acesso",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    ConectaTheme {
        Surface {
            LoginScreen()
        }
    }
}