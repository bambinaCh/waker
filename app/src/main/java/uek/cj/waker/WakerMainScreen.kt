package uek.cj.waker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import uek.cj.waker.model.Alarm
import uek.cj.waker.ui.theme.WakerTheme
import java.util.Calendar


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
* - Dialog Z-Auswhl: https://developer.android.com/develop/ui/compose/components/time-pickers-dialogs?hl=de
* - Git Ignore:      https://github.com/github/gitignore/blob/main/Android.gitignore
* - Number Picker:   https://stackoverflow.com/questions/75306878/how-can-i-make-a-number-picker-in-jetpack-compose
*                    https://github.com/ChargeMap/Compose-NumberPicker
* - Time:            https://www.geeksforgeeks.org/time-picker-in-android-using-jetpack-compose/
*                    https://stackoverflow.com/questions/75968843/jetpack-compose-format-date-string
*                    https://www.youtube.com/watch?v=EN9HtxsUe3A
*                    https://stackoverflow.com/questions/73332937/what-would-be-the-most-lightweight-way-to-observe-current-time-for-a-an-androi
*                    https://medium.com/mobile-innovation-network/date-formatting-in-compose-multiplatform-a-comprehensive-guide-bb059730afdc
* - Time %           https://medium.com/@TippuFisalSheriff/creating-a-timer-screen-with-kotlin-and-jetpack-compose-in-android-f7c56952d599
* - Divider:        https://developer.android.com/develop/ui/compose/components/divider?hl=de
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

        LazyColumn(
            //composable funktion scrollbare liste
            modifier = Modifier //jet compose funktion
                .fillMaxSize() //attribute
                .padding(innerPadding)
                .padding(16.dp),
        ) {
            if (alarms.isEmpty()) { // IF ELSE funktion um alarms zu rufen
                item {
                    Column (
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Keine Wakers gesetzt.")
                    }
                }
            } else {
                items(alarms) { alarm ->//for lop für jede alarm
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = alarm.time,//input des alarms
                        fontSize = 40.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    HorizontalDivider(thickness = 2.dp)
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable // Composable funktion für dialog (Neue Alarm)
fun AddAlarmDialog( // funktion für pop up wecker erstellen
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    val currentTime = Calendar.getInstance() //value zeigt aktuelle zeit. Compose funktion
    val context = LocalContext.current // um AlarmManager zu nutzen


    val timePickerState = rememberTimePickerState( //value auswahl Inpput für alarm. Compose funktion
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true
    )

    AlertDialog(
        onDismissRequest = { //jet compose Funktion (blog Kotlin)
            onDismiss()
        },
        confirmButton = { //jet compose funktion um alarm zu speichern
            Button(
                onClick = {
                    val time = "%02d:%02d".format(timePickerState.hour, timePickerState.minute) //Alarm value 2 stellig formatiert
                onConfirm(time) //neue zeit an haupt screen




                onDismiss() //dialog schliessen
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
        text = {
            TimePicker(state = timePickerState) // anzeigen Uhr
        }

    )
}
