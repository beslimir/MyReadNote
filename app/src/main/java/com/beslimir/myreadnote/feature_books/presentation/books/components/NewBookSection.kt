package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.beslimir.myreadnote.feature_books.presentation.books.BooksViewModel
import com.beslimir.myreadnote.feature_books.util.BookType
import com.beslimir.myreadnote.feature_books.presentation.books.BooksEvent
import com.beslimir.myreadnote.ui.theme.DarkGray

@Composable
fun NewBookSection(
    viewModel: BooksViewModel,
) {
    val bookTitleState = viewModel.bookTitle.value
    val bookAuthorState = viewModel.bookAuthor.value
    val bookTypeState = viewModel.bookType.value

    Box {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    viewModel.onEvent(BooksEvent.CloseBookSection)
                },
            color = DarkGray.copy(alpha = 0.75f)
        ) {

        }
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
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = {}
                ) //make window non clickable and without ripple effect
        ) {
            BookSectionItem(
                header = bookTitleState.header,
                inputValue = bookTitleState.inputValue,
                hint = bookTitleState.hint,
                textStyle = MaterialTheme.typography.h6,
                isHintVisible = bookTitleState.isHintVisible,
                onFocusChange = {
                    viewModel.onEvent(BooksEvent.ChangeTitleFocus(it))
                },
                onValueChange = {
                    viewModel.onEvent(BooksEvent.EnteredBookTitle(it))
                },
                onClearInput = {
                    viewModel.onEvent(BooksEvent.ClearTitleInput)
                }
            )
            BookSectionItem(
                header = bookAuthorState.header,
                inputValue = bookAuthorState.inputValue,
                hint = bookAuthorState.hint,
                textStyle = MaterialTheme.typography.h6,
                isHintVisible = bookAuthorState.isHintVisible,
                onFocusChange = {
                    viewModel.onEvent(BooksEvent.ChangeAuthorFocus(it))
                },
                onValueChange = {
                    viewModel.onEvent(BooksEvent.EnteredBookAuthor(it))
                },
                onClearInput = {
                    viewModel.onEvent(BooksEvent.ClearAuthorInput)
                }
            )
            DropDownMenu(
                header = bookTypeState.header,
                textStyle = MaterialTheme.typography.h6,
                onValueSelected = {
                    viewModel.onEvent(BooksEvent.SelectBookType(BookType.valueOf(
                        it.uppercase().replace(" ", "_")))
                    )
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
                        viewModel.onEvent(BooksEvent.CloseBookSection)
                    }
                ) {
                    Text(
                        text = "Cancel",
                        color = Color.Gray
                    )
                }
                Button(
                    onClick = {
                        viewModel.onEvent(BooksEvent.SaveNewBook)
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
}