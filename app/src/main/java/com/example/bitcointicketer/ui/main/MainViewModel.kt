package com.example.bitcointicketer.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bitcointicketer.Objects.Currencies
import com.example.bitcointicketer.Repository

class MainViewModel(private val repository: Repository =Repository()) : ViewModel() {
    fun fetchData():LiveData<Currencies?>{
        return repository.fetchData()
    }

}