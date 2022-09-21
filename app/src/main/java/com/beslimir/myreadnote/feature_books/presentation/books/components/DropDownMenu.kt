package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.beslimir.myreadnote.feature_books.util.BookType

@Composable
fun DropDownMenu(
    header: String,
    textStyle: TextStyle,
    onValueSelected: (String) -> Unit
) {
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
        text = header,
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
                        onValueSelected(s)
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