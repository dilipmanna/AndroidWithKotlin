package com.example.androidwithkotlin.utils

import com.example.androidwithkotlin.model.AndroidUI

class ProjectConstant {
    companion object{
        val uilist = listOf<AndroidUI>(
            AndroidUI("Date From Calender"),
            AndroidUI("Time From Clock"),
            AndroidUI("ProgressDialog"),
            AndroidUI("Full Screen Progress Bar"),
            AndroidUI("BottomSheetDialog"),
            AndroidUI("RoomDB"),
            AndroidUI("Retrofit"),
            AndroidUI("SharedPreference"),
            AndroidUI("ViewModel & LiveData"),
            AndroidUI("Simple Notes MVVM"),
            AndroidUI("Weather-MVVM")
        )
        var LOCATION_WOEID = "Location_Woeid" //woeid - Where On Earth ID

    }
}