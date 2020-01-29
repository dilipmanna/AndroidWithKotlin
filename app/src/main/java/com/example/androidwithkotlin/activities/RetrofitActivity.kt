package com.example.androidwithkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.adapters.EmployeeListAdapter
import com.example.androidwithkotlin.database.ProjectDB
import com.example.androidwithkotlin.entities.EmployeeEntity
import com.example.androidwithkotlin.model.SampleModel
import com.example.androidwithkotlin.networking.APIService
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val db = ProjectDB.getInstance(this)

        val layoutManager = StaggeredGridLayoutManager(1,1)
        recyclerView_employeeList.layoutManager = layoutManager

        btn_apiCall.setOnClickListener {
            showProgressDialog()
            val requestCall: Call<SampleModel> = APIService.create().getUserList("1")
            requestCall.enqueue(object: Callback<SampleModel> {
                override fun onFailure(call: Call<SampleModel>, t: Throwable) {
                    hideProgressDialog()
                    println(t)
                }
                override fun onResponse(call: Call<SampleModel>, response: Response<SampleModel>) {
                    if(response.isSuccessful) {
                        hideProgressDialog()
                        var sampleModel:SampleModel = response.body()!!
                        db!!.employeeDao().insertAll(*sampleModel.data.toTypedArray())
                    }
                }
            } )
        }

        btn_dbCall.setOnClickListener {
            val employeeEntityList = db!!.employeeDao().getAll()

            if(employeeEntityList.size > 0)
            {
                var employeeListAdapter = EmployeeListAdapter(employeeEntityList,this)
                recyclerView_employeeList.adapter = employeeListAdapter
                employeeListAdapter.OnItemClick = {
                    employeeItemClicked(it)
                }
            }
            else
            {
                Toast.makeText(this,"No records found in database",Toast.LENGTH_LONG).show()
            }
        }
        btn_deleteAll.setOnClickListener {
            db!!.employeeDao().deleteAll()
            btn_dbCall.performClick()
        }
    }
    fun employeeItemClicked(it: EmployeeEntity)
    {

    }
}
