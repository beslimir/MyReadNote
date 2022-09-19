package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookSectionItem(
    header: String,
    inputValue: String,
    hint: String,
    isHintVisible: Boolean = true,
    textStyle: TextStyle = TextStyle(),
    onFocusChange: (FocusState) -> Unit,
    onValueChange: (String) -> Unit,
    onClearInput: () -> Unit,
) {
    val grayTextStyle = textStyle.copy(
        color = Color.Gray
    )

    Column(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 8.dp
            )
    ) {
        Text(
            text = header,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(bottom = 4.dp)
        )
        Box(contentAlignment = Alignment.Center) {
            BasicTextField(
                value = inputValue,
                onValueChange = onValueChange,
                textStyle = grayTextStyle,
                cursorBrush = SolidColor(Color.Gray),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp))
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(MaterialTheme.colors.surface)
                    .onFocusChanged {
                        onFocusChange(it)
                    }
                    .padding(start = 8.dp, end = 32.dp, top = 4.dp, bottom = 4.dp)
            )
            if (isHintVisible) {
                Text(
                    text = hint,
                    style = grayTextStyle,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 8.dp, end = 32.dp, top = 4.dp, bottom = 4.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Canvas(modifier = Modifier.size(20.dp)) {
                    drawCircle(
                        color = Color.Gray,
                        style = Stroke(4f)
                    )
                }
                IconButton(
                    onClick = onClearInput,
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Delete input",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}