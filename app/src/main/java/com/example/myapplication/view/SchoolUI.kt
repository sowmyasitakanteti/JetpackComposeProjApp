package com.example.myapplication.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.SchoolDetails

@Composable
fun schoolItem(schoolDetails: SchoolDetails,navigateToDetails:(SchoolDetails) -> Unit) {
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp)
    {
        Surface(modifier = Modifier.clickable {
            navigateToDetails(schoolDetails)
        }) {
            Column(verticalArrangement = Arrangement.Center,
                 modifier = Modifier
                     .padding(4.dp)
                     .fillMaxHeight()) {

                 Text(text = schoolDetails.dbn,
                     style = MaterialTheme.typography.body1,
                     fontWeight = FontWeight.Bold)

                Text(text = schoolDetails.school_name,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(4.dp))

            }

        }

    }
}

