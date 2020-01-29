package com.example.androidwithkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.androidwithkotlin.R

class FullScreenProgressBarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_progress_bar)

        showProgressDialog()

        Handler().postDelayed({hideProgressDialog()},5000)
    }
}
