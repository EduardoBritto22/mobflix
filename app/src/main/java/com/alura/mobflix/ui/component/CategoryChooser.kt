package com.alura.mobflix.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.alura.mobflix.enum.VideoCategory
import com.alura.mobflix.ui.theme.MobFlixTheme

@Composable
fun CategoryChooser(
    onChoiceChange: (VideoCategory) -> Unit,
    modifier: Modifier = Modifier,
    firstOption: VideoCategory? = null
) {
    val categoryList = VideoCategory.values()

    Column(modifier = modifier) {

        val firstOptionText = firstOption?.tagName ?: categoryList.first().tagName

        var mExpanded by remember { mutableStateOf(false) }
        var mSelectedText by remember { mutableStateOf(firstOptionText) }
        var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

        val icon = if (mExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Text(
            text = "Category: ",
            fontSize = 14.sp,
            fontWeight = FontWeight(700),
            lineHeight = 16.sp,
            color = MaterialTheme.colors.onBackground
        )


        TextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                }
                .padding(top = 8.dp),
            readOnly = true,
            trailingIcon = {
                Icon(icon, "arrow icon",
                    Modifier.clickable { mExpanded = !mExpanded })
            },
            colors = TextFieldDefaults
                .textFieldColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    textColor = MaterialTheme.colors.onPrimary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
            textStyle = TextStyle.Default.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 18.sp,
                color = MaterialTheme.colors.onPrimary
            )

        )


        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
                .background(MaterialTheme.colors.primaryVariant)
        ) {

            categoryList.forEach { category ->
                DropdownMenuItem(
                    onClick = {
                        mSelectedText = category.tagName
                        mExpanded = false
                        onChoiceChange(category)
                    },

                ) {
                    val style = if (category.tagName == mSelectedText) {
                        FontStyle.Italic
                    } else {
                        FontStyle.Normal
                    }
                    Text(text = category.tagName, fontStyle = style)
                }
            }
        }

    }
}

@Preview(showBackground = false)
@Composable
private fun CategoryChooserPreview() {
    MobFlixTheme {
        Surface {
            CategoryChooser({})
        }
    }
}