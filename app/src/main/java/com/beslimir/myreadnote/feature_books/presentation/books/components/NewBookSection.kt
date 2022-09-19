package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beslimir.myreadnote.feature_books.presentation.books.BooksViewModel
import com.beslimir.myreadnote.feature_books.util.BooksEvent

@Composable
fun NewBookSection(
    viewModel: BooksViewModel = hiltViewModel()
) {
    val bookTitleState = viewModel.bookTitle.value
    val bookAuthorState = viewModel.bookAuthor.value
    val bookTypeState = viewModel.bookType.value

    Column(
        modifier = Modifier
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 64.dp,
                bottom = 64.dp
            )
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        BookSectionItem(
            header = bookTitleState.header,
            inputValue = bookTitleState.inputValue,
            hint = bookTitleState.hint,
            textStyle = MaterialTheme.typography.h5,
            isHintVisible = bookTitleState.isHintVisible,
            onFocusChange = {
                viewModel.onEvent(BooksEvent.ChangeTitleFocus(it))
            },
            onValueChange = {
                viewModel.onEvent(BooksEvent.EnteredBookTitle(it))
            }
        )
        BookSectionItem(
            header = bookAuthorState.header,
            inputValue = bookAuthorState.inputValue,
            hint = bookAuthorState.hint,
            textStyle = MaterialTheme.typography.h5,
            isHintVisible = bookAuthorState.isHintVisible,
            onFocusChange = {
                viewModel.onEvent(BooksEvent.ChangeAuthorFocus(it))
            },
            onValueChange = {
                viewModel.onEvent(BooksEvent.EnteredBookAuthor(it))
            }
        )
        BookSectionItem(
            header = bookTypeState.header,
            inputValue = bookTypeState.inputValue,
            hint = bookTypeState.hint,
            textStyle = MaterialTheme.typography.h5,
            isHintVisible = bookTypeState.isHintVisible,
            onFocusChange = {
                viewModel.onEvent(BooksEvent.ChangeBookTypeFocus(it))
            },
            onValueChange = {
                viewModel.onEvent(BooksEvent.EnteredBookType(it))
            }
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {

                }
            ) {
                Text(
                    text = "Cancel",
                    color = Color.Gray
                )
            }
            Button(
                onClick = {

                }
            ) {
                Text(
                    text = "Save",
                    color = Color.Gray
                )
            }
        }
    }
}