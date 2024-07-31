package com.fantasmas_dev.tip_calculator_compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.fantasmas_dev.tip_calculator_compose.ui.theme.Tip_calculator_composeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            Tip_calculator_composeTheme {
                        TipTimeLayout()
                }
            }
            composeTestRule.onNodeWithText("Сумма чека")
                .performTextInput("10")
            composeTestRule.onNodeWithText("Процент чаевых")
                .performTextInput("20")
            val expectedTip = NumberFormat.getCurrencyInstance().format(2)
            composeTestRule.onNodeWithText("Чаевые: $expectedTip").assertExists(
                "Нода с данным текстом не найдена"
            )
        }
    }