package com.app.featurez

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.TestConstants
import com.app.featurez.ui.FeatureZScreen
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(
    application = HiltTestApplication::class,
    sdk = [TestConstants.testSdk],
    qualifiers = TestConstants.testQualifiers,
    instrumentedPackages = [TestConstants.testInstrumentedPackages]
)
class FeatureZScreenTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() {
        composeTestRule.setContent {
            FeatureZScreen(
                modifier = Modifier,
                onGoBackClick = {}
            )
        }

        composeTestRule.onNodeWithText("Feature Z").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go back").assertIsDisplayed()
    }


    @Test
    fun `buttons work correctly`() {
        var goBackCaptured = false

        composeTestRule.setContent {
            FeatureZScreen(
                modifier = Modifier,
                onGoBackClick = {
                    goBackCaptured = true
                }
            )
        }

        composeTestRule.onNodeWithText("Go back").performClick()

        Assert.assertTrue(goBackCaptured)
    }
}