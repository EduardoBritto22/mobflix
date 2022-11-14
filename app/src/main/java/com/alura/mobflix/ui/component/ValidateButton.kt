package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.mobflix.ui.theme.MobFlixTheme


@Composable
fun ValidateButton(
    label: String,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = MaterialTheme.colors.primary
) {

    Button(
        onClick = onButtonClicked,
        content = {
            Text(
                text = label,
                Modifier.padding(2.dp),
                color = Color.White
            )
        },
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
    , colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
    )

}

@Preview(showBackground = true)
@Composable
private fun ValidateButtonPreview() {
    MobFlixTheme {
        Surface {
            ValidateButton("Watch now",{})
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun DeleteButtonPreview() {
    MobFlixTheme {
        Surface {
            ValidateButton("Watch now",{}, buttonColor = Color.Red)
        }
    }
}