package jp.co.human.localnote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun LoginScreen() {
    val loginId = rememberSaveable() { mutableStateOf("") }
    val password = rememberSaveable() { mutableStateOf("")}
    val message = rememberSaveable() { mutableStateOf("")}
    ScreenFrame {
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
    }
}

@Composable
fun ScreenFrame(content: @Composable ColumnScope.() -> Unit){
    Column(
        Modifier.fillMaxSize()
            .safeDrawingPadding().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        content()
    }
}