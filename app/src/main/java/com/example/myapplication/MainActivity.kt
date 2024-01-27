package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.model.SchoolDetails
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.view.schoolItem
import com.example.myapplication.viewModel.SchoolViewModel

class MainActivity : ComponentActivity() {
    
    val schoolViewModel by viewModels<SchoolViewModel>()

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SchoolList(schoolList = schoolViewModel.schoolListResponse, {
                        startActivity(DetailsActivity.newIntent(this,it))
                         } )
                        schoolViewModel.getSchoolList()
                    }

                }
            }
        }
    }


@Composable
fun SchoolList(schoolList: List<SchoolDetails>, navigateToDetails:(SchoolDetails) -> Unit){
    LazyColumn{
        itemsIndexed(items = schoolList){ index, item ->
            schoolItem(schoolDetails = item,navigateToDetails)
        }

    }
}



