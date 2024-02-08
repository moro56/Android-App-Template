package com.app.featurea.impl

import com.app.core.test.MainDispatcherRule
import com.app.core.test.TestConstants
import com.app.featurea.impl.ui.FeatureAContract
import com.app.featurea.impl.ui.FeatureAViewModel
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
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
class FeatureAViewModelTest {

    @get:Rule
    val rule = MainDispatcherRule()

    @Test
    fun `create random number action works correctly`() = runTest {
        val viewModel = FeatureAViewModel()
        Assert.assertEquals(0, viewModel.uiState.value.number)

        viewModel.sendEvent(FeatureAContract.Event.CreateRandomNumber)
        Assert.assertNotEquals(0, viewModel.uiState.value.number)
    }

    @Test
    fun `show snackBar action works correctly`() = runTest {
        val viewModel = FeatureAViewModel()
        val viewStates = mutableListOf<FeatureAContract.Effect>()
        val jobEffect = launch(UnconfinedTestDispatcher()) {
            viewModel.uiEffect.collectLatest { viewStates.add(it) }
        }

        viewModel.sendEvent(FeatureAContract.Event.ShowSnackBar)

        Assert.assertTrue(viewStates.contains(FeatureAContract.Effect.ShowSnackBar))

        jobEffect.cancel()
    }
}