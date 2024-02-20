package com.app.featurex

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.TestConstants
import com.app.featurex.ui.FeatureXScreen
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
class FeatureXScreenTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() {
        composeTestRule.setContent {
            FeatureXScreen(
                modifier = Modifier,
                onGoToCClick = {}
            )
        }

        composeTestRule.onNodeWithText("Feature X").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go to C").assertIsDisplayed()
    }

    @Test
    fun `buttons work correctly`() {
        var showCCaptured = false

        composeTestRule.setContent {
            FeatureXScreen(
                modifier = Modifier,
                onGoToCClick = {
                    showCCaptured = true
                }
            )
        }

        composeTestRule.onNodeWithText("Go to C").performClick()

        Assert.assertTrue(showCCaptured)
    }
}
