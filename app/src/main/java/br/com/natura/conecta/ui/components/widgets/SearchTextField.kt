package br.com.natura.conecta.ui.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.SoftOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    shadow: Boolean,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    val isFocused = remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(100.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Transparent),
        shadowElevation = if (shadow) 15.dp else 0.dp,
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                onSearchChange(it)
            },
            shape = RoundedCornerShape(100),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFocused.value = focusState.isFocused
                },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = DarkOrange
                )
            },
            trailingIcon = {
                if (isFocused.value && searchText.isNotBlank()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            tint = DarkOrange
                        )
                    }
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mic),
                        contentDescription = null,
                        tint = DarkOrange
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Pesquisar",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = DarkOrange,
                focusedTextColor = Color.Black,
                disabledTextColor = Color.Black,
                selectionColors = TextSelectionColors(
                    handleColor = SoftOrange,
                    backgroundColor = Color.Transparent
                )
            )
        )
    }
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    SearchTextField(searchText = "", onSearchChange = {}, shadow = false)
}