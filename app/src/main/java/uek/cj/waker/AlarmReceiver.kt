package uek.cj.waker


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast

/* Quellen:
* - onReceive:  https://stackoverflow.com/questions/47742474/kotlin-call-a-function-to-update-ui-from-broadcastreceiver-onreceive
* - BroadcastReceiver: https://developer.android.com/develop/background-work/background-tasks/broadcasts?hl=de
*
* */

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) { // alarm wird automatisch ausgeloest
        Toast.makeText(context, "Waker!", Toast.LENGTH_LONG).show()

        // Vibration beim auslösen der Waker
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(10000, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(10000)
        }

        val fullScreenIntent = Intent(context, AlarmActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        context.startActivity(fullScreenIntent) //vollbildmodus
    }
}
