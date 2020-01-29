package com.example.androidwithkotlin.activities

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.adapters.UIListAdapter
import com.example.androidwithkotlin.model.AndroidUI
import com.example.androidwithkotlin.utils.ProjectConstant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG,"OnCreate")
        val layoutManager = StaggeredGridLayoutManager(1,1)
        rvUIItem.layoutManager = layoutManager
        var uiListAdapter = UIListAdapter(ProjectConstant.uilist)
        rvUIItem.adapter = uiListAdapter

        uiListAdapter.OnItemClick = {
            Log.i(TAG,"${it.name} was clicked")
            uiItemClicked(it)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"OnResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i(TAG,"OnPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG,"OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"OnDestroy")
    }

    private fun uiItemClicked(androidUI: AndroidUI) {
        when(androidUI.name){
            "Date From Calender" -> {goToNext(DateActivity::class.java)}
            "Time From Clock" -> {goToNext(TimeActivity::class.java)}
            "ProgressDialog" -> {goToNext(ProgressDialogActivity::class.java)}
            "Full Screen Progress Bar" -> {goToNext(FullScreenProgressBarActivity::class.java)}
            "BottomSheetDialog" ->{goToNext(BottomSheetDialogActivity::class.java)}
            "RoomDB" -> {goToNext(RoomDBActivity::class.java)}
            "Retrofit" -> {goToNext(RetrofitActivity::class.java)}
            "SharedPreference" ->{goToNext(SharedPreferenceActivity::class.java)}
            "ViewModel & LiveData" ->{goToNext(LiveDataActivity::class.java)}
            "Simple Notes MVVM" ->{goToNext(NotesActivity::class.java)}
            "Weather-MVVM" ->{goToNext(WeatherActivity::class.java)}
        }
    }
}

