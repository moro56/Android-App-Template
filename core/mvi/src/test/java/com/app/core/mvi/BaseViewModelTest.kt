package com.app.core.mvi

import com.app.core.mvi.models.UIEffect
import com.app.core.mvi.models.UIEvent
import com.app.core.mvi.models.UIState
import com.app.core.test.MainDispatcherRule
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class BaseViewModelTest {

    @get:Rule
    val rule = MainDispatcherRule()

    @Test
    fun `test send event, set state and set effect methods`() = runTest {
        val viewModel = createViewModel()
        val viewStates = mutableListOf<TestContract.Effect>()
        val jobEffect = launch(UnconfinedTestDispatcher()) {
            viewModel.uiEffect.collectLatest { viewStates.add(it) }
        }

        Assert.assertEquals("", viewModel.uiState.value.value)

        val newValue = "test"
        viewModel.sendEvent(TestContract.Event.ChangeState(newValue))

        Assert.assertEquals(newValue, viewModel.uiState.value.value)
        Assert.assertEquals(viewStates.size, 1)

        jobEffect.cancel()
    }

    // MOCKS

    private fun createViewModel() =
        object : BaseViewModel<TestContract.Event, TestContract.State, TestContract.Effect>() {
            override fun createInitialState() = TestContract.State(value = "")

            override fun handleEvent(event: TestContract.Event) {
                when (event) {
                    is TestContract.Event.ChangeState -> {
                        setState { copy(value = event.newValue) }
                        setEffect { TestContract.Effect.ShowEffect }
                    }
                }
            }
        }

    private class TestContract {
        sealed class Event : UIEvent {
            data class ChangeState(val newValue: String) : Event()
        }

        data class State(val value: String) : UIState

        sealed class Effect : UIEffect {
            data object ShowEffect : Effect()
        }
    }
}
