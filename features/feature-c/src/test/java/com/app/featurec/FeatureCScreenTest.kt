package com.app.featurec

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.TestConstants
import com.app.featurec.ui.FeatureCScreen
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
class FeatureCScreenTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() {
        composeTestRule.setContent {
            FeatureCScreen(
                modifier = Modifier,
                onGoBackClick = {}
            )
        }

        composeTestRule.onNodeWithText("Feature C").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go back").assertIsDisplayed()
    }

    @Test
    fun `buttons work correctly`() {
        var goBackCaptured = false

        composeTestRule.setContent {
            FeatureCScreen(
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
