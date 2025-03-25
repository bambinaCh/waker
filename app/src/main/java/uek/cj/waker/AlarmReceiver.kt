package uek.cj.waker


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/* Quellen:
* - onReceive:  https://stackoverflow.com/questions/47742474/kotlin-call-a-function-to-update-ui-from-broadcastreceiver-onreceive
* - BroadcastReceiver: https://developer.android.com/develop/background-work/background-tasks/broadcasts?hl=de
*
* */

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Toast.makeText(context, "Waker!", Toast.LENGTH_LONG).show()

        val fullScreenIntent = Intent(context, AlarmActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        context.startActivity(fullScreenIntent)
    }
}
