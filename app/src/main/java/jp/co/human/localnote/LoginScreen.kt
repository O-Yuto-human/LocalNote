package jp.co.human.localnote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen() {
    val loginId = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("")}
    val message = rememberSaveable { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("ログイン")
        TextField(
            value = loginId.value,
            onValueChange = { loginId.value = it },
            label = { Text("ID") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it},
            label = { Text("パスワード") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick =  {
            message.value = "入力したID：" + loginId.value
        }) {
            Text("入力を確認")
        }
        Button(onClick =  {
            message.value = ""
            loginId.value = ""
            password.value = ""
        }){
            Text("クリア")
        }
        Text(message.value)
    }

}