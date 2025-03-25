# 📱 Waker – Challenge Wecker
**Autorin:** Chaimaa Jarite  
**Technologien:** Kotlin, Jetpack Compose, Material3

---

##  Idee & Motivation

Waker ist eine native Android-App, bei der man den Wecker nicht einfach per Knopfdruck ausschalten kann. Sondern muss man eine zufällige Challenge absolvieren (z. B. Handy schütteln oder eine Frage beantworten), umm den Waker abzustellen.

Die Idee entstand aus einem persönlichen Problem und zwar ichh gewöhne mich schnell an Weckern, deshalb brauche ich täglich eine neue Art aufzustehen um wirklich wach zu werden.

---

## Funktionen (geplant & umgesetzt)

###  Umgesetzt:
- Alarm kann per Dialog erstellt werden.
- Die gesetzten Alarme werden auf dem Hauptscreen angezeigt.
- Aktuelle Uhrzeit wird als Default im Dialog übernommen.
- TimePicker als digitale Eingabe vorhanden.
- Alarmzeit wird im Format `HH:mm` dargestellt.
- Benutzeroberfläche in Jetpack Compose gestaltet.
- App-Icon wurde erstellt und in `AndroidManifest.xml` eingebunden.

### Noch nicht umgesetzt:
- Challenges zum Deaktivieren des Alarms.
- Sensor-Auswertung (Gyroskop, Licht, Nähe etc.).
- Hintergrundprozesse für Alarmfunktion (AlarmManager, ForegroundService).
- Navigation zu einem Challenge-Screen.
- Mikrofon- & Kamera-Funktionalität.

---

## Testprotokoll

Das Testen wurde auf dem **Android Emulator** durchgeführt, da kein physisches Android-Gerät verfügbar war.

**Testdurchführung:** Chaimaa El Jarite  
**Siehe Tabelle „Testprotokoll“ weiter unten**

---

## Schichtentrennung

Ich habe versucht, dass die App die Regeln zur Schichtentrennung befolgt:

- **A.** Die App verwendet ein separates `model`-Package, in dem die `Alarm.kt` Klasse definiert ist.
- **B.** Das Modell (`Alarm`) ist klar von der Benutzeroberfläche (`WakerMainScreen`) getrennt.
- **C.** Einfache Logik wie das Speichern in einer Liste erfolgt noch direkt in der UI. Eine ViewModel Schicht wäre wünschenswert, habe ich aber aus Zeitgründen noch nicht implementiert.

---

## Versionsverwaltung (SCM)

- Jeder Commit enthält nur ein Thema → **atomar**
- Alle Commits sind beschreibend formuliert
- Historie dokumentiert (siehe Testprotokoll)
- Screenshots der Git-Historie:

---

## Code Conventions

- Methoden (ausser UI) sind unter 30 Zeilen
- Variablen und Funktionen auf Englisch benannt
- PascalCase/CamelCase beachtet
- Jetpack Compose Linter aktiv (Android Studio integriert)

---

## Darstellung vs. Funktion

Ich habe versucht, meine Mockups und Storyboard möglichst genau umzusetzen.  
Die Darstellung war mir wichtig, im Nachhinein hätte ich mich aber mehr auf die Logik konzentrieren sollen.

**Learnings:**
- Nicht alles, was einfach aussieht (z. B. Uhrzeit per Dialog wählen), ist technisch einfach.
- Fokus sollte stärker auf Funktionalität liegen als auf Design.
- Kleinere Ziele → bessere Umsetzung.

---

## Berechtigungen & Sensoren

In späteren Releases wurde ich gerne folgende Berechtigungen verwenden:
- Mikrofon (Sprach-Challenges)
- Kamera (Selfie zur Deaktivierung)
- Sensoren: Beschleunigung, Gyroskop, Licht, Nähe
- Hintergrundprozesse (Wecker-Funktion)

---

## Tutorials & Quellen

Ich habe viele Tutorials, Blogartikel und die offizielle Android-Dokumentation verwendet:
- [Android Developer TimePicker](https://developer.android.com/develop/ui/compose/components/time-pickers-dialogs)
- [Material3 AlertDialog](https://developer.android.com/develop/ui/views/components/dialogs?hl=de)
- [Jetpack Compose Grundlagen](https://developer.android.com/develop/ui/compose/quick-guides)
 - General Infos:   https://www.youtube.com/watch?v=V4IxattGNJY
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
---

## Reflexion

**A. SOLL (Absicht):**  
Eine funktionierende Wecker-App mit Challenges und sensorbasierten Aufgaben entwickeln.

**B. IST (Resultat):**  
Grundstruktur, Alarmliste und TimePicker sind fertig. Dialog funktioniert. Challenges & AlarmManager fehlen noch.

**C. Erkenntnis:**  
Ich habe mir sehr viel vorgenommen. Nächstes Mal würde ich mit weniger Features starten und mich mehr auf die Funktion konzentrieren. Die UI war mir sehr wichtig, aber die Logik hätte Vorrang haben sollen.

---

## Erfüllte Rahmenbedingungen 

- Sensoren geplant (5 Punkte)
- Mehrere Views (1 Punkt)
- Zustandsverwaltung (1 Punkt)
- Hintergrundlogik geplant (4 Punkte)
- Eigenes App-Icon (1 Punkt)
- Interaktion mit Mikrofon/Kamera vorgesehen (2 Punkte)

---

## 🧾 Testprotokoll (Auszug)

| Zeitpunkt            | Testfall                                               | Geprüft von      | Ergebnis                       |
|----------------------|--------------------------------------------------------|------------------|--------------------------------|
| 2025-03-25 01:00     | Spacer der Wakers erhöht                               | Chaimaa Jarite   | OK / Funktioniert wie erwartet |
| 2025-03-25 00:55     | Fontgrösse der Wakers erhöht                            | Chaimaa Jarite   | OK / Funktioniert wie erwartet |
| 2025-03-25 00:45     | Icon angepasst                                         | Chaimaa Jarite   | OK / Funktioniert wie erwartet |
| ...                  | ... siehe Tabelle im Projekt (Protokoll als CSV)       |                  |                                |

---

## Ausblick

- Challenges mit Sensoren aktivieren
- AlarmManager & Foreground Service integrieren
- Daten persistent speichern (z. B. mit Room)
- Challenge- und Einstellungen-Screens hinzufügen

---

## Fazit

Ich habe extrem viel gelernt – nicht nur über Jetpack Compose, sondern auch über Projektplanung, Fehlersuche und meine eigenen Limits.  
Die App ist nicht perfekt, aber sie ist mein Werk – und ich bin stolz darauf.
