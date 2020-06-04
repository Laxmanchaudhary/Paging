package com.example.paginglibrary.Api

import com.example.paginglibrary.Model.userResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    //https://reqres.in/api/users?page=2

    @GET("users")
    fun getusers(@Query("page") page:Int):Call<userResponce>

    companion object{
        operator fun invoke():Api{
            var BASE_URL:String="https://reqres.in/api/"

            return Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create()).
            baseUrl(BASE_URL).
            build().
            create(Api::class.java)

        }
    }
}