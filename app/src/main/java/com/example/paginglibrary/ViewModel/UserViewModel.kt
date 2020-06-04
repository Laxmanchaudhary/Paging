package com.example.paginglibrary.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paginglibrary.DataSourceFactory.DataSourceFactory
import com.example.paginglibrary.Datasource.UserDataSource
import com.example.paginglibrary.Model.User
import javax.sql.DataSource

class UserViewModel: ViewModel() {
    val pagedList:LiveData<PagedList<User>>
    val datasourcelivedata:LiveData<UserDataSource>

    init {
        var datafac=DataSourceFactory()
        datasourcelivedata=datafac.userdatasourcelive
        var config= PagedList.Config.Builder().setEnablePlaceholders(true).
        setPageSize(UserDataSource.TOTAL_PAGE).build()

        pagedList=LivePagedListBuilder(datafac,config).build()
    }
}