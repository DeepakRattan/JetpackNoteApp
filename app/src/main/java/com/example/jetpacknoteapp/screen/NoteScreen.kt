package com.example.jetpacknoteapp.screen

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacknoteapp.R
import com.example.jetpacknoteapp.components.NoteButton
import com.example.jetpacknoteapp.components.NoteInputText
import com.example.jetpacknoteapp.model.Note
import com.example.jetpacknoteapp.util.formatDate
import java.time.format.DateTimeFormatter

/**
 * Created by Deepak Rattan on 09/04/23
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icon"
                )
            },
            backgroundColor = Color(0xFFDADFE3)
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(8.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) {
                        title = it
                    }
                })

            NoteInputText(
                modifier = Modifier.padding(8.dp),
                text = description,
                label = "Add a note",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) {
                        description = it
                    }
                })

            NoteButton(text = "Save",
                onClick = {
                    Log.d("save", "Title is $title")
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        onAddNote(Note(title = title, description = description))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Noted Added", Toast.LENGTH_LONG).show()
                    }
                })

            Divider(modifier = Modifier.padding(10.dp))

            // List of Notes
            LazyColumn {
                items(notes) { note ->
                    NoteRow(note = note, onNoteClicked = {
                        onRemoveNote(it)
                        Toast.makeText(context, "Noted Removed", Toast.LENGTH_LONG).show()
                    })
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,
) {

    Surface(
        modifier = modifier
            .padding(8.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp,
                    bottomStart = 33.dp
                )
            )
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFFDEF6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier
                .clickable {
                    onNoteClicked(note)
                }
                .padding(
                    horizontal = 14.dp,
                    vertical = 10.dp
                ),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2, color = Color.Black)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            Text(
                text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.caption
            )
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        notes = emptyList(),
        onAddNote = {},
        onRemoveNote = {})
}