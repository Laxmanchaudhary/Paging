package com.example.paginglibrary.Datasource

import androidx.paging.PageKeyedDataSource
import com.example.paginglibrary.Api.Api
import com.example.paginglibrary.Model.User
import com.example.paginglibrary.Model.userResponce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.Key

class UserDataSource: PageKeyedDataSource<Int, User>() {


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>) {

             var users= Api().getusers(FIRST_PAGE)

                 users.enqueue(object :Callback<userResponce>{

                     override fun onFailure(call: Call<userResponce>, t: Throwable) {
                         TODO("Not yet implemented")
                     }

                     override fun onResponse(call: Call<userResponce>, response: Response<userResponce>) {
                         if (response.isSuccessful){
                             var apires= response.body()!!
                             var useritem=apires.data
                             useritem?.let {
                                 callback.onResult(it,null, FIRST_PAGE+1)
                             }
                         }
                     }

                 })
    }


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

            var users= Api().getusers(params.key)

                users.enqueue(object :Callback<userResponce>{

                    override fun onFailure(call: Call<userResponce>, t: Throwable) {
                    }

                    override fun onResponse(call: Call<userResponce>, response: Response<userResponce>) {
                        if (response.isSuccessful){
                            var apires= response.body()!!
                            var useritem=apires.data
                            useritem?.let {
                                callback.onResult(it,params.key+1)
                            }
                        }
                    }

                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        var users= Api().getusers(params.key)
        users.enqueue(object :Callback<userResponce>{

            override fun onFailure(call: Call<userResponce>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<userResponce>, response: Response<userResponce>) {
                if (response.isSuccessful){
                    var apires= response.body()!!
                    var useritem=apires.data
                    useritem?.let {

                        var keyy=if (params.key>1) params.key-1  else 0
                        callback.onResult(it,keyy)
                    }
                }
            }

        })

    }

    companion object{
        const val  TOTAL_PAGE:Int=6
        const val FIRST_PAGE:Int=1
    }

}