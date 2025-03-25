# **Waker – Challenge Wecker**

**Autorin:** Chaimaa Jarite  
**Technologien:** Kotlin, Jetpack Compose, Material3

## **Idee und Motivation**

Waker ist eine native Android App, bei der man den Wecker nicht einfach per Knopfdruck ausschalten kann. Stattdessen muss man eine zufaellige Aufgabe absolvieren, zum Beispiel das Handy schuetteln oder eine Frage beantworten, um den Waker auszuschalten.

Die Idee entstand aus einem persoenlichen Problem. Ich gewoehne mich schnell an Wecker, deshalb brauche ich taeglich eine neue Art aufzustehen, um wirklich wach zu werden.

## **Funktionen (geplant und umgesetzt)**

### Umgesetzt
- Alarm kann per Dialog erstellt werden  
- Die gesetzten Alarme werden auf dem Hauptscreen angezeigt  
- Aktuelle Uhrzeit wird als Standard im Dialog uebernommen  
- TimePicker als digitale Eingabe vorhanden  
- Alarmzeit wird im Format `HH:mm` dargestellt  
- Benutzeroberflaeche mit Jetpack Compose gestaltet  
- App Icon wurde erstellt und im Manifest eingebunden

### Noch nicht umgesetzt
- Aufgaben zum Deaktivieren des Alarms  
- Sensor Auswertung (Gyroskop, Licht, Naehe usw.)  
- Hintergrundprozesse fuer die Alarmfunktion  
- Navigation zu einem Aufgaben Screen  
- Mikrofon und Kamera Funktionalitaet

## **Schichtentrennung**

Ich habe versucht, mich an die Regeln der Schichtentrennung zu halten.

- Das Modell (Alarm) befindet sich im separaten `model` Verzeichnis  
- Die Benutzeroberflaeche (`WakerMainScreen`) ist getrennt vom Modell  
- Die UI enthaelt minimale Logik wie die Darstellung der Liste  
- Eine ViewModel Schicht waere sinnvoll gewesen, habe ich aber aus Zeitgruenden nicht umgesetzt

## **Versionsverwaltung**

- Jeder Commit enthaelt nur ein Thema  
- Commit Beschreibungen sind verstaendlich formuliert  
- Git wurde mit Android Studio verwendet  
- Nachweis erfolgt durch Screenshots der Git Historie

## **Code Conventions**

- Methoden ausserhalb der UI sind unter 30 Zeilen  
- Variablen und Methoden wurden englisch benannt  
- PascalCase und camelCase wurden eingehalten  
- Android Studio Linter war aktiviert

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
- Hintergrundprozesse zum Ausloesen des Alarms

## **Quellen und Tutorials**

Ich habe viele Tutorials und Dokumentationen genutzt:

- https://developer.android.com/develop/ui/compose/components/time-pickers-dialogs  
- https://developer.android.com/develop/ui/views/components/dialogs?hl=de  
- https://developer.android.com/develop/ui/compose/quick-guides  
- https://www.youtube.com/watch?v=V4IxattGNJY  
- https://developer.android.com/develop/ui/compose/state  
- https://developer.android.com/develop/ui/compose/components/fab  
- https://blog.kotlin-academy.com/dialogs-in-jetpack-compose-2b7f72b14651  
- https://www.youtube.com/watch?v=gtxWnkUPhwU  
- https://stackoverflow.com/questions/75968843/jetpack-compose-format-date-string  
- https://github.com/ChargeMap/Compose-NumberPicker  
- https://github.com/github/gitignore/blob/main/Android.gitignore  
- https://www.geeksforgeeks.org/time-picker-in-android-using-jetpack-compose/  
- https://developer.android.com/reference/kotlin/androidx/compose/material3/ExperimentalMaterial3Api  

## **Abgabe und Bewertung**

**Erfuellte Rahmenbedingungen:**

- Mehrere Views verwendet  
- Zustandsverwaltung vorhanden  
- TimePicker mit aktueller Uhrzeit eingebaut  
- Eigenes Icon eingebunden

**Noch offen:**

- Sensoren auslesen  
- Hintergrundprozesse fuer die Weckerfunktion  
- Mikrofon und Kamera Nutzung
