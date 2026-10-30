package jp.co.human.localnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.human.localnote.ui.theme.LocalNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LocalNoteTheme {
                Scaffold {innerPadding ->
                    Column(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    ) {
                        ScreenFrame { LoginScreen() }
                    }
                }
            }
        }
    }
}



@Composable
fun MainScreen(){
    val message = remember {
        mutableStateOf("初期設定ミス")
    }
    Column{
        Text(message.value)
        Button(
            {
                message.value = "ボタン押した後ミス"
            }
        ) {
            Text("ここミス")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    LocalNoteTheme {
        MainScreen()
    }
}