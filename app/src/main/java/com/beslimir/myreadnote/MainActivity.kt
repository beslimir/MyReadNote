package com.beslimir.myreadnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.beslimir.myreadnote.ui.theme.MyReadNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyReadNoteTheme {
                
            }
        }
    }
}