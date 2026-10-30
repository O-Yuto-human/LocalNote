package jp.co.human.localnote

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import jp.co.human.localnote.ui.theme.LocalNoteTheme

@Composable
fun Counter(){
    val message = remember {
        mutableStateOf("0")
    }
    Column() {
        Text(message.value)
        Button(
            {message.value += 1}
        ) {
            Text("増やす")
        }
    }
}