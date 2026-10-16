package jp.co.human.localnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jp.co.human.localnote.ui.theme.LocalNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LocalNoteTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    Column{
        Text(
            text = "Yuto Oka"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    LocalNoteTheme {
        MainScreen()
    }
}