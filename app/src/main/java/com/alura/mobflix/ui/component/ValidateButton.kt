package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
    modifier: Modifier = Modifier
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
            .padding(bottom = 20.dp)
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