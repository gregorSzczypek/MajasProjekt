package com.abschlussapp.majateichmann.luckyvstreamerlist.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.local.StreamerDatabase
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.remote.StreamerApi

const val TAG = "AppRepository"

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class AppRepository(private val api: StreamerApi, private val database: StreamerDatabase) {

    /**
     * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
     * Variable memes. Falls der Call nicht funktioniert, wird die Fehlermeldung geloggt
     */
    val streamerList: LiveData<List<Streamer>> = database.streamerDao.getAll()

    suspend fun getStreamer(){
        try{
            val streamerData = api.retrofitService.getStreamers().streamer
            database.streamerDao.insertAll(streamerData)
        }catch(e: Exception){
            Log.e(TAG,"Error loading Data from API: $e")
        }
    }

    suspend fun deleteAllStreamer(){
        try{
            database.streamerDao.deleteAll()
        }catch(e: Exception){
            Log.e(TAG,"Failed to delete all Streamer from Database: $e")
        }
    }

    suspend fun updateStreamer(streamer: Streamer){
        try{
            database.streamerDao.update(streamer)
        }catch(e: Exception){
            Log.d(TAG,"Failed to update StreamerDatabase: $e")
        }
    }
}