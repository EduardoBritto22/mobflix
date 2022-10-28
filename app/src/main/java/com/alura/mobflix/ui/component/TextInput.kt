package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alura.mobflix.ui.theme.MobFlixTheme
import com.alura.mobflix.ui.theme.TextDisabledColor

@Composable
fun TextInput(
    text : String,
    label: String,
    placeHolder: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(
            text = "$label: ",
            fontSize = 14.sp,
            fontWeight = FontWeight(700),
            lineHeight = 16.sp,
            color = MaterialTheme.colors.onBackground
        )

        TextField(
            value = text,
            onValueChange = {onTextChange(it)},
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    text = placeHolder,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 18.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            colors = TextFieldDefaults
                .textFieldColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    placeholderColor = TextDisabledColor,
                    textColor = MaterialTheme.colors.onPrimary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
        )

    }

}

@Preview(showBackground = false)
@Composable
private fun TextInputPreview() {
    MobFlixTheme {
        Surface {
            TextInput("","Url", "Ex: N3h5A0oAzsk",{})
        }
    }
}