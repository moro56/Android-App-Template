package com.app.featurey.impl

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.TestConstants
import com.app.featurey.impl.ui.FeatureYScreen
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
class FeatureYScreenTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() {
        composeTestRule.setContent {
            FeatureYScreen(
                modifier = Modifier,
                onGoToZClick = {}
            )
        }

        composeTestRule.onNodeWithText("Feature Y").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go to Z").assertIsDisplayed()
    }


    @Test
    fun `buttons work correctly`() {
        var showZCaptured = false

        composeTestRule.setContent {
            FeatureYScreen(
                modifier = Modifier,
                onGoToZClick = {
                    showZCaptured = true
                }
            )
        }

        composeTestRule.onNodeWithText("Go to Z").performClick()

        Assert.assertTrue(showZCaptured)
    }
}