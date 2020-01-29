package com.example.androidwithkotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidwithkotlin.utils.ProgressDialog

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mProgressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog.DialogCreate("")
    }

    protected fun goToNext(cls:Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

    protected fun goToNext(cls: Class<*>, extras: Bundle) {
        val intent = Intent(this, cls)
        intent.putExtras(extras)
        startActivity(intent)
    }

    fun showProgressDialog() {
        if(!mProgressDialog.isShowing) {
            mProgressDialog.showProgressDialog()
        }
    }

    fun hideProgressDialog() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.hideProgressDialog()
        }
    }
}
