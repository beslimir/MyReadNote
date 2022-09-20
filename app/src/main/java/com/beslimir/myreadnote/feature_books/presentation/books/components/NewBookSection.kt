package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beslimir.myreadnote.feature_books.presentation.books.BooksViewModel
import com.beslimir.myreadnote.feature_books.util.BookType
import com.beslimir.myreadnote.feature_books.util.BooksEvent
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
                    viewModel.closeNewBookSection()
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
            DropdownDemo(textStyle = MaterialTheme.typography.h6)
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = {
                        viewModel.closeNewBookSection()
                    }
                ) {
                    Text(
                        text = "Cancel",
                        color = Color.Gray
                    )
                }
                Button(
                    onClick = {
                        viewModel.closeNewBookSection()
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

@Composable
fun DropdownDemo(textStyle: TextStyle) {
    var expanded by remember { mutableStateOf(false) }
    val dropDownItems = BookType.values().asList()
        .map { bookType ->
            bookType.name
                .replace("_", " ")
                .lowercase()
                .replaceFirstChar { it.uppercase() }
        }
    var dropDownIcon by remember { mutableStateOf(Icons.Default.ArrowDropDown) }
    var selectedIndex by remember { mutableStateOf(0) }
    val grayTextStyle = textStyle.copy(color = Color.Gray)

    Text(
        text = "Book type",
        fontSize = 12.sp,
        color = Color.DarkGray,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 4.dp
            )
    )
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 8.dp
            )
            .clip(RoundedCornerShape(5.dp))
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.surface)
            .clickable {
                dropDownIcon = Icons.Default.ArrowDropUp
                expanded = true
            }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = dropDownItems[selectedIndex],
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 8.dp,
                        end = 64.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
                    .background(
                        MaterialTheme.colors.surface
                    ),
                style = grayTextStyle,
                maxLines = 1
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .height(400.dp)
                    .wrapContentWidth()
                    .background(Color.LightGray)
            ) {
                dropDownItems.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedIndex = index
                        expanded = false
                        dropDownIcon = Icons.Default.ArrowDropDown
                    }) {
                        Text(
                            text = s,
                            style = grayTextStyle,
                            maxLines = 1
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = {
                        dropDownIcon = Icons.Default.ArrowDropUp
                        expanded = true
                    },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        imageVector = dropDownIcon,
                        contentDescription = "Open DropDown",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}