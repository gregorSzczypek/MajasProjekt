package com.abschlussapp.majateichmann.luckyvstreamerlist.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.AppRepository
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.local.getDatabase
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.remote.StreamerApi
import kotlinx.coroutines.launch

enum class ApiStatus {LOADING, ERROR, DONE}

const val TAG = "MainViewModel"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = AppRepository(StreamerApi,database)

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    val streamer = repository.streamer

    init {
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try{
                repository.getStreamer()
                _loading.value = ApiStatus.DONE
            }catch(e: Exception){
                Log.e(TAG,"Loading Data failed: $e")
                if(streamer.value.isNullOrEmpty()){
                    _loading.value = ApiStatus.ERROR
                }else{
                    _loading.value = ApiStatus.DONE
                }
            }
        }
    }
}