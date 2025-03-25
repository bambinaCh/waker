package uek.cj.waker

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uek.cj.waker.model.Alarm

object AlarmStorage {
    private const val PREF_NAME = "alarm_prefs"
    private const val KEY_ALARMS = "alarms"

    fun saveAlarms(context: Context, alarms: List<Alarm>) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = Gson().toJson(alarms)
        prefs.edit().putString(KEY_ALARMS, json).apply()
    }


}
