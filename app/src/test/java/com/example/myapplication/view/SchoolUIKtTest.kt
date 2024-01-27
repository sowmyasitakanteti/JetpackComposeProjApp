package com.example.myapplication.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class SchoolUIKtTest{

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myComposeUnitTest() {
        composeTestRule.setContent {
            val textFieldSchool = composeTestRule.onNodeWithText("Liberation Diploma Plus High School")
            assertTrue(textFieldSchool.equals("Liberation Diploma Plus High School"))

            val textFielddbn = composeTestRule.onNodeWithText("02M260")
            assertTrue(textFielddbn.equals("02M260"))


        }
    }
    @Test
    fun myComposePerformTest(){
        composeTestRule.setContent {
            composeTestRule.onNodeWithText("02M260").performClick()

        }
    }
}