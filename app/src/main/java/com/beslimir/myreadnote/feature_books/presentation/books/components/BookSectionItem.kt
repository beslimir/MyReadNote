package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
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
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 4.dp
            )
    ) {
        Text(
            text = header,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(bottom = 4.dp)
        )
        Box {
            BasicTextField(
                value = inputValue,
                onValueChange = onValueChange,
                textStyle = textStyle,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth()
                    .onFocusChanged {
                        onFocusChange(it)
                    }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            )
            if (isHintVisible) {
                Text(
                    text = hint,
                    style = textStyle,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}