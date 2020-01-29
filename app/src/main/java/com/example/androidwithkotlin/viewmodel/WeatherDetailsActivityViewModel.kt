package com.example.androidwithkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.androidwithkotlin.model.WeatherModel
import com.example.androidwithkotlin.repository.WeatherDetailsActivityRepository

class WeatherDetailsActivityViewModel (application: Application):AndroidViewModel(application){
    val repository = WeatherDetailsActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val weatherModel: LiveData<WeatherModel>
    init {
        this.showProgress = repository.showProgress;
        this.weatherModel = repository.weatherModel;
    }
    fun getWeather(woeId : Int){
        repository.getWeather(woeId)
    }

}