package com.example.paginglibrary.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginglibrary.Adapter.UserAdapter
import com.example.paginglibrary.R
import com.example.paginglibrary.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter=UserAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewModelProvider.AndroidViewModelFactory(application).create(UserViewModel::class.java).
        pagedList.observe(this,Observer{
             adapter.submitList(it)

            })

        user_recyclerview.also {
            it.setHasFixedSize(true)
            it.layoutManager=LinearLayoutManager(this)
            it.adapter=adapter
        }




    }
}
