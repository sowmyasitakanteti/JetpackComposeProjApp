package com.example.myapplication.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.SchoolDetails

@Composable
fun schoolDetailsItem(schoolDetails: SchoolDetails) {
    Surface {
        Text(text = schoolDetails.overview_paragraph,
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp))
    }
}