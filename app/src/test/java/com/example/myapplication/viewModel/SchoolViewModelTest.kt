package com.example.myapplication.viewModel

import com.example.myapplication.model.SchoolDetails
import com.example.myapplication.network.ApiService
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SchoolViewModelTest {

    private lateinit var viewModel:SchoolViewModel
    private lateinit var retrofit: Retrofit

    @Before
    fun setUp(){
        viewModel = SchoolViewModel()
    }

    @Test
    suspend fun `can get School Details dbn is Empty` () {
        val api = ApiService.getInstance("https://data.cityofnewyork.us/")
        val response = api.getSchoolDetails().get(0)
        // verify the response is OK
        assertThat(response.dbn).isEmpty()
    }

    @Test
    suspend fun can_get_school_Details_school_name_is_empty(){
        val api = ApiService.getInstance("https://data.cityofnewyork.us/")
        val response = api.getSchoolDetails().get(0)
        // verify the response is OK
        assertThat(response.school_name).isEmpty()

    }
    @Test
    suspend fun `can get School Details dbn is` () {
        val api = ApiService.getInstance("https://data.cityofnewyork.us/")
        val response = api.getSchoolDetails().get(0)
        // verify the response is OK
        assertThat(response.dbn).isNotEmpty()
    }

    @Test
    suspend fun `can get School Details schoolname is` () {
        val api = ApiService.getInstance("https://data.cityofnewyork.us/")
        val response = api.getSchoolDetails().get(0)
        // verify the response is OK
        assertThat(response.dbn).isNotEmpty()
    }

    @Test
    suspend fun `can get School Details dbn is Equal` () {
        val api = ApiService.getInstance("https://data.cityofnewyork.us/")
        val response = api.getSchoolDetails().get(0)
        // verify the response is OK
        assertThat(response.dbn).isEqualTo("02M260")
    }

    @Test
    suspend fun `can get School Details schoolName is Equal` () {
        val api = ApiService.getInstance("https://data.cityofnewyork.us/")
        val response = api.getSchoolDetails().get(1)
        // verify the response is OK
        assertThat(response.school_name).isEqualTo("Liberation Diploma Plus High School")
    }


}