package uek.cj.waker

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.graphics.Color
import android.util.TypedValue
import android.widget.LinearLayout
import android.view.Gravity
import android.media.MediaPlayer
import android.os.Vibrator
import android.os.VibrationEffect
import android.widget.Button
import android.widget.Toast

/*
* Quellen:
*  - Vibration:     https://medium.com/@rowaido.game/how-to-use-vibration-effects-in-android-apps-using-jetpack-compose-0fcd8e339931
* - MediaPlayer:    https://medium.com/@myofficework000/building-a-media-player-app-with-jetpack-media3-in-jetpack-compose-16ae8c35f955
*
* */

class AlarmActivity : Activity() {

    private var mediaPlayer: MediaPlayer? = null // Ton funktion - Objekt
    private var vibrator: Vibrator? = null // vibration funktion - Objekt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.addFlags( //vollbild fenster
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
        )

        val alarmTime = intent.getStringExtra("alarm_time") ?: "Jetzt" // Intent zeit holen sonst default jetzt

        // layout erstellen Waker Fenster
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.BLACK)
        }

        val titleView = TextView(this).apply { // title
            text = "Waker"
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 36f)
        }

        val timeView = TextView(this).apply { // tastdächliche value con der ausgelöste Alarm
            text = alarmTime
            setTextColor(Color.MAGENTA)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 64f)
        }


        val motionButton = Button(this).apply { // Button für
            text = "Bewegungsaufgabe"
            setOnClickListener {
                stopAlarm()// wenn gelöst alarm stopt
                Toast.makeText(this@AlarmActivity, "Bewegung erkannt! Alarm gestoppt.", Toast.LENGTH_SHORT).show()
                finish() //aufgabe ende
            }
        }

        val logicButton = Button(this).apply {
            text = "Aufgabe lösen"
            setOnClickListener {
                stopAlarm() // wen gelöst alarm stopt
                Toast.makeText(this@AlarmActivity, "Aufgabe gelöst! Alarm gestoppt.", Toast.LENGTH_SHORT).show()
                finish() //aufgabe ende
            }
        }

        //view zu title, zeit, Buttons und layout selbst
        layout.addView(titleView)
        layout.addView(timeView)
        layout.addView(motionButton)
        layout.addView(logicButton)

        setContentView(layout)

        // ton starten
        mediaPlayer = MediaPlayer.create(this, android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()

        // vibrierein auslösen - Chatpgt
        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        val pattern = longArrayOf(0, 500, 500, 500, 500)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator?.vibrate(VibrationEffect.createWaveform(pattern, 0)) // 0 = repeat from beginning
        } else {
            vibrator?.vibrate(pattern, 0)
        }
    }

    private fun stopAlarm() { // funtion um mediaPlayer und vibration zu stopen
        mediaPlayer?.stop() //anhaltet ton
        mediaPlayer?.release()
        mediaPlayer = null

        vibrator?.cancel() //anhaltet vibration
    }

    override fun onDestroy() { //endet Waker
        super.onDestroy()
        stopAlarm()
    }
}
