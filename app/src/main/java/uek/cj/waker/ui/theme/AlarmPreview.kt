package uek.cj.waker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uek.cj.waker.ui.theme.WakerTheme

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun AlarmScreenPreview() {
    WakerTheme {
        AlarmScreenPreviewView()
    }
}

@Composable
fun AlarmScreenPreviewView(alarmTime: String = "07:30") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Waker", fontSize = 36.sp, color = Color.White)
        Spacer(modifier = Modifier.height(24.dp))
        Text(alarmTime, fontSize = 64.sp, color = Color.Magenta)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { }) {
            Text("Bewegungsaufgabe")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { }) {
            Text("Aufgabe lösen")
        }
    }
}
