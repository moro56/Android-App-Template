package com.app.featureb

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.TestConstants
import com.app.featureb.ui.FeatureBScreen
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
class FeatureBScreenTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() {
        composeTestRule.setContent {
            FeatureBScreen(
                modifier = Modifier,
                onGoBackClick = {},
                onGoToMainClick = {}
            )
        }

        composeTestRule.onNodeWithText("Feature B").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go to Main").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go back").assertIsDisplayed()
    }


    @Test
    fun `buttons work correctly`() {
        var goBackCaptured = false
        var showMainCaptured = false

        composeTestRule.setContent {
            FeatureBScreen(
                modifier = Modifier,
                onGoBackClick = {
                    goBackCaptured = true
                },
                onGoToMainClick = {
                    showMainCaptured = true
                }
            )
        }

        composeTestRule.onNodeWithText("Go to Main").performClick()
        composeTestRule.onNodeWithText("Go back").performClick()

        Assert.assertTrue(goBackCaptured)
        Assert.assertTrue(showMainCaptured)
    }
}