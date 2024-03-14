package com.example.services.data

import android.app.Service.START_NOT_STICKY
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject

class Provider @Inject constructor(
    private val context: Context
) {
    private val link = "https://catfact.ninja/facts?limit=6"


    fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        cat()
        return START_NOT_STICKY
    }

    fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun cat() {
        CoroutineScope(Dispatchers.IO).launch {
            var c: List<Fact> = emptyList()
            try {
                val url = URL(link)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 10000
                val response = connection.inputStream.bufferedReader().readText()
                connection.disconnect()
                val json = Gson().fromJson(response, Map::class.java)
                c = (json["data"] as List<Map<String, Any>>).map {
                    Fact(
                        fact = it["fact"] as String,
                        length = (it["length"] as Double).toInt()
                    )
                }

                withContext(Dispatchers.Main) {
                    val intent = Intent("com.example.Services")
                    intent.putExtra("catFacts", Gson().toJson(c))
                    context.sendBroadcast(intent)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}