package com.example.paginglibrary.DataSourceFactory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paginglibrary.Datasource.UserDataSource
import com.example.paginglibrary.Model.User

class DataSourceFactory:DataSource.Factory<Int,User>(){
    var userdatasourcelive=MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, User> {
        var datasource=UserDataSource()
        userdatasourcelive.postValue(datasource)
        return datasource
    }
}