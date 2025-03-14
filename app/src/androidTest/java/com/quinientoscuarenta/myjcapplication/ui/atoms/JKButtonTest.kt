package com.quinientoscuarenta.myjcapplication.ui.atoms

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class JKButtonTest {

    // Compose rule to get access to the composable component.
    // The same concept as in Jest unit testing,
    // when we assign the element (NOT component) to be testes to a variable to reuse it across the tests.
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun setUp() {
        // Arrange
        val callback: () -> Unit = mockk()
        composeTestRule.setContent {

        }

        // Act
        composeTestRule.onNodeWithText("Button").performClick()

        // Assert
        verify { callback() }

    }
}