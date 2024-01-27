package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ScaleGestureDetector
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.SchoolDetails
import com.example.myapplication.ui.theme.MyApplicationTheme

class DetailsActivity: ComponentActivity() {

    private val schoolDetails:SchoolDetails by lazy {
        intent?.getSerializableExtra(DETAILS_ITEM) as SchoolDetails
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Text(text ="${schoolDetails.overview_paragraph}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(4.dp))
            }
        }
    }
    companion object
    {
        private const val DETAILS_ITEM = "Details_id"
        fun newIntent(context: Context,schoolDetails: SchoolDetails) =
            Intent(context,DetailsActivity::class.java).apply {
                putExtra(DETAILS_ITEM,schoolDetails)
            }
    }
}