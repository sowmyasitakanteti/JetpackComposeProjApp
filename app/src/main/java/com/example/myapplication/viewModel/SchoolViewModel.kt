package com.example.myapplication.viewModel

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.SchoolDetails
import com.example.myapplication.network.ApiService
import kotlinx.coroutines.launch

class SchoolViewModel:ViewModel() {

    var schoolListResponse:List<SchoolDetails> by mutableStateOf(listOf())
    var errorMessage:String by mutableStateOf("")

    fun getSchoolList() {
        val baseUrl ="https://data.cityofnewyork.us/"
        viewModelScope.launch {
            val apiService = ApiService.getInstance(baseUrl)
            try {
                val schoolList = apiService.getSchoolDetails()
                schoolListResponse = schoolList
            }
            catch (e:Exception) {
                errorMessage = e.message.toString()

            }
        }
    }
}