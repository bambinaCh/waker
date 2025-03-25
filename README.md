# **Waker – Challenge Wecker**

**Autorin:** Chaimaa Jarite  
**Technologien:** Kotlin, Jetpack Compose, Material3  
**Pages:** [Waker Pages Site](https://bambinach.github.io/WakerSite/)

## **Idee und Motivation**

Waker ist eine native Android App, bei der man den Wecker nicht einfach per Knopfdruck ausschalten kann. Stattdessen muss man eine zufaellige Aufgabe absolvieren, zum Beispiel das Handy schuetteln oder eine Frage beantworten, um den Waker auszuschalten.

Die Idee kamm aus einem persoenlichen Problem. Ich gewoehne mich schnell an Wecker, deshalb brauche ich taeglich eine neue Art aufzustehen, um wirklich wach zu werden.

## **Funktionen (geplant und umgesetzt)**

### *Umgesetzt*
* Alarm kann per Dialog erstellt werden  
* Die gesetzten Alarme werden auf dem Hauptscreen angezeigt  
* Aktuelle Uhrzeit wird als Standard im Dialog uebernommen  
* TimePicker als digitale Eingabe vorhanden  
* Alarmzeit wird im Format `HH:mm` dargestellt  
* Benutzeroberflaeche mit Jetpack Compose gestaltet  
* App Icon wurde erstellt und im Manifest eingebunden  
* Alarme werden *persistent gespeichert* (SharedPreferences)  
* *Hintergrundprozess mit AlarmManager* ist eingebaut (Alarm wird technisch korrekt geplant)  
* *Aktuator (Vibration)* ist beim Erstellen und Ausloesen eines Alarms implementiert  
* *Vollbildanzeige beim Alarm-Zeitpunkt* ist als `AlarmActivity` vorhanden  

### *Hinweise und Einschraenkungen*
* AlarmActivity oeffnet sich nicht automatisch beim Ausloesen des Alarms im Emulator (vermutlich wegen Emulator-Beschraenkungen, auf echten Geraeten funktioniert es)  
* Die Vibration beim Ausloesen funktioniert technisch, aber auch hier kann es im Emulator zu Einschraenkungen kommen  
* Der Hintergrundprozess wurde mit (*AlarmManager*) und (*BroadcastReceiver*) umgesetzt. Ob der Alarm korrekt im Hintergrund ausgeloest wird, konnte aufgrund der Emulator-Einschraenkungen nicht vollstaendig ueberprueft werden. Die (*AlarmActivity*) ist implementiert, erscheint aber beim Ausloesen des Alarms im Test nicht zuverlaessig.  
* Die volle Logik fuer das Deaktivieren des Alarms mit Aufgaben ist noch *nicht eingebaut*, aber vorbereitet

### *Noch nicht umgesetzt*
* Aufgaben zum Deaktivieren des Alarms  
* Sensor Auswertung (Gyroskop, Licht, Naehe usw.)  
* Navigation zu einem Aufgaben Screen  
* Mikrofon und Kamera Funktionalitaet
  
---
## **Aenderungen gegenueber der Planung**


- Ich habe schnell gemerkt: Design klappt, aber die technische Umsetzung war schwieriger als gedacht. Deshalb habe ich den Fokus auf das Design gelegt.  
- Die geplanten Sensor-Challenges musste ich erstmal verschieben, damit die Alarmfunktion vollständig funktioniert.  
- Navigation, Einstellungen und Challenges habe ich bewusst weggelassen, um die Hauptfunktion getestet und stabil abgeben zu können.  
- Der Zeitaufwand war deutlich hoeher als erwartet. Deshalb habe ich klar priorisiert, was wirklich wichtig ist.  
- Einige Funktionen wie Bewegungserkennung oder Matheaufgaben sind vorbereitet, aber noch nicht eingebaut.  
- Die App wurde wie geplant mit Jetpack Compose umgesetzt. Manche Designelemente wie die analoge Uhr habe ich vereinfacht.  
- Beim Ausloesen des Alarms wird ein eigenes Vollbild-Layout (AlarmActivity) mit Ton und Vibration angezeigt.  
- Die AlarmActivity wird technisch korrekt gestartet, aber im Emulator funktioniert sie nicht immer zuverlaessig.     
- Der Alarmton ist eine eigene .wav-Datei, eingebunden im Ordner `res/raw/`.


---

## **Schichtentrennung**

Ich habe versucht, mich an die Regeln der Schichtentrennung zu halten:

- Das Modell (`Alarm`) befindet sich im separaten `model` Verzeichnis  
- Die Benutzeroberflaeche (`WakerMainScreen`) ist getrennt vom Modell  
- Die UI enthaelt minimale Logik wie die Darstellung der Liste  
- Eine ViewModel Schicht waere sinnvoll gewesen, habe ich aber aus Zeitgruenden nicht umgesetzt

---

## **Versionsverwaltung**

Ich habe versucht:

- Jeder Commit enthaelt nur ein Thema
- Commit-Beschreibungen sind verstaendlich formuliert  
- Git wurde mit Android Studio verwendet  
- Nachweis erfolgt durch Screenshots der Git-Historie

---

## **Code Conventions**

Ich habe versucht, die Code Conventions einzuhalten:

- Methoden ausserhalb der UI sind unter 30 Zeilen  
- Variablen und Methoden wurden englisch benannt  
- PascalCase und camelCase wurden eingehalten  
- Android Studio Linter war aktiviert
  
---

## **Wie Linter starten**

Ich habe `ktlint` in Android Studio verwendet. So kannst du ihn ausfuehren:

*1. Terminal oeffnen im Projektordner*  
```bash
./gradlew ktlintCheck
```
2. Oder ueber Plugin Ktlint direkt in Android Studio installieren und ueber Rechtsklick ausfuehren

---

## **Darstellung und Funktion**

Ich wollte mein Storyboard und Mockup exakt umsetzen, aber das war schwieriger als erwartet.  
Ich habe zu viel Zeit ins Design investiert und zu wenig in die Logik.

**Erkenntnis:**  
Weniger waere mehr gewesen  
Naechstes Mal liegt der Fokus auf Funktion statt Design  
Ich setze mir realistischere Ziele

## **Berechtigungen und Sensoren (geplant)**

- Mikrofon fuer Sprachaufgaben  
- Kamera fuer Selfie oder QR Code  
- Sensoren: Beschleunigung, Gyroskop, Licht, Naehe  

## **Quellen und Tutorials**

Ich habe viele Tutorials, Blogartikel, StackOverflow-Antworten und die offizielle Android-Dokumentation verwendet:

- [TimePicker in Jetpack Compose](https://developer.android.com/develop/ui/compose/components/time-pickers-dialogs)
- [Material3 AlertDialog](https://developer.android.com/develop/ui/views/components/dialogs?hl=de)
- [Jetpack Compose Quick Guides](https://developer.android.com/develop/ui/compose/quick-guides)
- [Scaffold Composable](https://developer.android.com/develop/ui/compose/quick-guides/content/create-scaffold?hl=de)
- [State Handling in Compose](https://developer.android.com/develop/ui/compose/state?hl=de)
- [Floating Action Button in Compose](https://developer.android.com/develop/ui/compose/components/fab?hl=de)
- [ExperimentalMaterial3Api Referenz](https://developer.android.com/reference/kotlin/androidx/compose/material3/ExperimentalMaterial3Api)
- [Divider Komponente in Compose](https://developer.android.com/develop/ui/compose/components/divider?hl=de)
- [AlertDialog API](https://developer.android.com/reference/kotlin/androidx/compose/material3/AlertDialog)
- [Android.gitignore von GitHub](https://github.com/github/gitignore/blob/main/Android.gitignore)
- [Number Picker Library](https://github.com/ChargeMap/Compose-NumberPicker)
- [Beispiel-FAB Code](https://github.com/android/snippets/blob/a7117c0da26b85a9e005d700a7ae9dec859bb8bd/compose/snippets/src/main/java/com/example/compose/snippets/components/FloatingActionButton.kt)
- [StackOverflow – Number Picker in Compose](https://stackoverflow.com/questions/75306878/how-can-i-make-a-number-picker-in-jetpack-compose)
- [StackOverflow – Zeitformatierung in Compose](https://stackoverflow.com/questions/75968843/jetpack-compose-format-date-string)
- [StackOverflow – aktuelle Zeit beobachten](https://stackoverflow.com/questions/73332937/what-would-be-the-most-lightweight-way-to-observe-current-time-for-a-an-androi)
- [Kotlin Academy – Dialoge in Jetpack Compose](https://blog.kotlin-academy.com/dialogs-in-jetpack-compose-2b7f72b14651)
- [Date Formatting in Compose Multiplatform](https://medium.com/mobile-innovation-network/date-formatting-in-compose-multiplatform-a-comprehensive-guide-bb059730afdc)
- [Timer Screen mit Compose – Medium](https://medium.com/@TippuFisalSheriff/creating-a-timer-screen-with-kotlin-and-jetpack-compose-in-android-f7c56952d599)
- [GeeksForGeeks – TimePicker in Compose](https://www.geeksforgeeks.org/time-picker-in-android-using-jetpack-compose/)
- [YouTube – Jetpack Compose Einführung](https://www.youtube.com/watch?v=V4IxattGNJY)
- [YouTube – AlertDialog in Compose](https://www.youtube.com/watch?v=gtxWnkUPhwU)
- [YouTube – Compose Dialog Tutorial](https://www.youtube.com/watch?v=XI35XG1rECs)
- [YouTube – Dialogs in Compose](https://www.youtube.com/watch?v=5u917TZkwvI)
- [YouTube – TimePicker Beispiel](https://www.youtube.com/watch?v=EN9HtxsUe3A)
- [StackOverflow – BroadcastReceiver UI](https://stackoverflow.com/questions/47742474/kotlin-call-a-function-to-update-ui-from-broadcastreceiver-onreceive)
- [Android Developer – BroadcastReceiver](https://developer.android.com/develop/background-work/background-tasks/broadcasts?hl=de)

## **Abgabe und Bewertung**

**Erfuellte Rahmenbedingungen:**

- Mehrere Views verwendet  
- Zustandsverwaltung vorhanden  
- TimePicker mit aktueller Uhrzeit eingebaut  
- Eigenes Icon eingebunden  
- Aktuator (Vibration bei Alarmerstellung und Alarm-Auslösung) umgesetzt  
- Hintergrundprozess mit AlarmManager implementiert  
- Alarme werden persistent gespeichert (SharedPreferences)  
- AlarmActivity ist vorbereitet und eingebaut

**Noch offen:**

- Sensoren auslesen  
- AlarmActivity funktioniert nur teilweise und nicht zuverlässig auf Emulator  
- Mikrofon und Kamera Nutzung  
- Aufgaben-Screen und Challenge-Erkennung beim Weckruf

## Git Nachweise

![Git Verlauf - 100 Commits](<img width="592" alt="100_Commits" src="https://github.com/user-attachments/assets/46702a1f-8d0a-4f00-b5ee-94ad47447909" />)  
![Git Verlauf - Erste Commits]( <img width="485" alt="erste_Commits" src="https://github.com/user-attachments/assets/f03b44af-6d17-4ef0-a80f-82c0a4e38ba8" /> )
![Git Verlauf - Letzte Commits](<img width="493" alt="letzte_Commits" src="https://github.com/user-attachments/assets/9c4225a1-0044-40e4-8f59-fecb9f5929e5" />)


