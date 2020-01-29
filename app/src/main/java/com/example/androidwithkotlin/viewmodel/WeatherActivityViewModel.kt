package com.example.androidwithkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.androidwithkotlin.model.Location
import com.example.androidwithkotlin.repository.WeatherActivityRepository

class WeatherActivityViewModel(application: Application):AndroidViewModel(application) {
    val repository = WeatherActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val locationList: LiveData<List<Location>>
    init {
        this.showProgress = repository.showProgress;
        this.locationList = repository.locationList;
    }

    fun searchLocation(searchStr : String){
        repository.searchLocation(searchStr)
    }

}