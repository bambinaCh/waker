package uek.cj.waker

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.graphics.Color
import android.util.TypedValue
import android.widget.LinearLayout
import android.view.Gravity
/*
* Quellen:
*  - Vibration:     https://medium.com/@rowaido.game/how-to-use-vibration-effects-in-android-apps-using-jetpack-compose-0fcd8e339931
*
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

        layout.addView(titleView)
        layout.addView(timeView)


        setContentView(layout)
    }
}
