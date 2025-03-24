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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.AlertDialog
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



/* Quelle
* - General Infos:   https://www.youtube.com/watch?v=V4IxattGNJY
* - listOf<Alarm>:   https://developer.android.com/develop/ui/compose/state?hl=de
* - Floating Button: https://developer.android.com/develop/ui/compose/components/fab?hl=de
*                    https://github.com/android/snippets/blob/a7117c0da26b85a9e005d700a7ae9dec859bb8bd/compose/snippets/src/main/java/com/example/compose/snippets/components/FloatingActionButton.kt#L61-L68
*
* - Scaffold:        https://developer.android.com/develop/ui/compose/quick-guides/content/create-scaffold?hl=de
* - Exp. Material    https://developer.android.com/reference/kotlin/androidx/compose/material3/ExperimentalMaterial3Api
* - Dialog:          https://developer.android.com/develop/ui/views/components/dialogs?hl=de
*                    https://blog.kotlin-academy.com/dialogs-in-jetpack-compose-2b7f72b14651
* - Al.Di. Button:   https://www.youtube.com/watch?v=gtxWnkUPhwU
*                    https://blog.kotlin-academy.com/dialogs-in-jetpack-compose-2b7f72b14651
*                    https://www.youtube.com/watch?v=XI35XG1rECs
*                    https://www.youtube.com/watch?v=5u917TZkwvI
* - Git Ignore:      https://github.com/github/gitignore/blob/main/Android.gitignore
* - Number Picker:   https://stackoverflow.com/questions/75306878/how-can-i-make-a-number-picker-in-jetpack-compose
*                    https://github.com/ChargeMap/Compose-NumberPicker
*
*
* */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WakerMainScreen() {
    var alarms by rememberSaveable { mutableStateOf(listOf<Alarm>()) } // variabe verwaltet und speichert alle alarms
    var showDialog by rememberSaveable { mutableStateOf(false) } // variable steuerung für pop up

    Scaffold( //jet compose composable gerüst
        topBar = { //jet compose composable Parameter Leiste mit titel
            TopAppBar(//jet compose composable
                title = { //slot für titel
                    Text("Wakers") // composable funktion ui element
                        },
                navigationIcon = { //slot für Icon
                    Icon( //ui element
                        Icons.Default.AccessTime, // compose icons library,icon Uhr
                        contentDescription = "Uhr Symbol"
                    )
                }
            )
        },
        floatingActionButton = { //jet compose composable Teil
            LargeFloatingActionButton( //Composable Button von Android Compose alamr hinzufügen
                onClick = { //klick Function
                    showDialog = true //mit claas alarm
                },
                shape = CircleShape
                ) {
                Icon( //composable funktion ui element
                    Icons.Filled.Add, // compose icons library, Add (+) icon
                    contentDescription = "Neuen Alarm hinzufügen"
                )
            }
        }
    ) { innerPadding -> //Hauptinhalt (liste der Wakers)

        Column( //composable funktion ui element
            modifier = Modifier //jet compose funktion
                .fillMaxSize() //attribute
                .padding(16.dp),
            verticalArrangement = Arrangement.Center //jet compose funktion
        ) {
            if (alarms.isEmpty()) { // IF ELSE funktion um alarms zu rufen
                Text("Keine Wakers gesetzt.")
            } else {
                for (alarm in alarms) { //for lop für jede alarm
                    Text("alarm.time") //input des alarms
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        if (showDialog) { //If funktion für aktive Dialog
            AddAlarmDialog( //AddAlarmDialog composable aufrufen
                onDismiss = { //compose funktion
                    showDialog = false
                },
                onConfirm = { // compose funktion damit Dialog auf popt
                    newTime -> // neue alarm
                    alarms = alarms + Alarm(newTime) // neue alarm speichert
                    showDialog = false // nach der neue alarm schliesst der Dialog
                }
            )
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

@Composable // Composable funktion für dialog (Neue Alarm)
fun AddAlarmDialog( // funktion für pop up wecker erstellen
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var selectedHour by rememberSaveable { mutableStateOf("") } // variabe speichert alarm input -Stunde
    var selectedMinute by rememberSaveable { mutableStateOf("") } // variabe speichert alarm input -Minute
    AlertDialog(
        onDismissRequest = { //jet compose Funktion (blog Kotlin)
            onDismiss()
        },
        confirmButton = { //jet compose funktion um alarm zu speichern
            Button(
                onClick = {
                onConfirm(input)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = { //jet compose funktion um zu abbrechen
            Button(
                onClick = {
                    onDismiss()
                }) {
                    Text("Abbrechen")
            }
        },

    )
}
