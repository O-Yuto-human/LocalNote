package jp.co.human.localnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.co.human.localnote.ui.theme.LocalNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LocalNoteTheme {
                App()
            }

            /*LocalNoteTheme {
                Scaffold {innerPadding ->
                    Column(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    ) {
                        ScreenFrame { LoginScreen() }
                    }
                }*/

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

fun loginError(id: String, password: String): String{
    if(id.isBlank() || password.isBlank()){
        return "IDとパスワードを入力してください"
    }
    if(id != "student" || password != "practice123"){
        return "IDまたはパスワードが違います"
    }
    return ""
}

@Composable
fun App(){
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = "login"
    ){
        composable("login"){
            LoginScreen(
                onLogin = {nav.navigate("home")}
            )
        }
        composable("home") {
            HomeScreen(
                onLogout = { nav.popBackStack()} // ログアウトしたらログイン画面に戻る
            )
        }
    }
}