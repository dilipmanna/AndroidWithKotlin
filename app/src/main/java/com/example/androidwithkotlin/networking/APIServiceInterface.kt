package com.example.androidwithkotlin.networking

import com.example.androidwithkotlin.model.Location
import com.example.androidwithkotlin.model.SampleModel
import com.example.androidwithkotlin.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIServiceInterface {
    @GET("api/users")
    fun getUserList(@Query("page") page: String): Call<SampleModel>
    /*
    @GET("api.php")
    fun getBookList(): Call<BookBase>

    // Query used for single or two parameter generally
    // @GET("api.php")
    // fun getBookDetails(@Query("book")book: String): Call<BookDetails>

    // Query map used for multiple parameter generally
    @GET("api.php")
    fun getBookDetails(@QueryMap filter: HashMap<String,String>): Call<BookDetails>



    @GET("api.php?")
    fun getBookList(): Call<BookBase>*/


    //@GET("serach/?")
    @GET("search?")
    fun getLocation(@Query("query") searchString: String): Call<List<Location>>

    @GET("{woeid}")
    fun getWeather(@Path("woeid") woeid: Int): Call<WeatherModel>
}