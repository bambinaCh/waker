package uek.cj.waker

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uek.cj.waker.model.Alarm
import uek.cj.waker.ui.theme.WakerTheme

/*Quelle
* - listOf<Alarm> :https://developer.android.com/develop/ui/compose/state?hl=de
* - Floating Button: https://developer.android.com/develop/ui/compose/quick-guides/content/create-floating-action-button?hl=de
*                    https://github.com/android/snippets/blob/a7117c0da26b85a9e005d700a7ae9dec859bb8bd/compose/snippets/src/main/java/com/example/compose/snippets/components/FloatingActionButton.kt#L61-L68
*
*
*
* */


@Composable
fun WakerMainScreen() {
    var alarms by rememberSaveable { mutableStateOf(listOf<Alarm>()) } // speichert alarm objekte

    Scaffold(
        NewAlarmButton(onClick = {
            //neue alarm funktion
        }) {
            Icon(Icons.Filled.Add, "Neue Alarm hinzufügen.")
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))



            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("here to be press")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WakerMainScreenPreview() {
    WakerTheme {
        WakerMainScreen()
    }
}