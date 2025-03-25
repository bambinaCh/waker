package uek.cj.waker

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView

class AlarmActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.addFlags(  // volbild fenster
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
        )


        val alarmTime = intent.getStringExtra("alarm_time") ?: "Jetzt" // Intent zeit holen sonst default jetzt

        // Layout erstellen
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


        /*
        setContentView(TextView(this).apply {
            text = "Waker!"
            textSize = 32f
        })*/
    }
}
