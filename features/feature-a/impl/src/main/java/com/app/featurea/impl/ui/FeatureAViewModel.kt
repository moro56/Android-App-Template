package com.app.featurea.impl.ui

import com.app.core.mvi.BaseViewModel

/**
 * Feature A ViewModel
 */
class FeatureAViewModel :
    BaseViewModel<FeatureAContract.Event, FeatureAContract.State, FeatureAContract.Effect>() {

    override fun createInitialState() = FeatureAContract.State(number = 0)

    override fun handleEvent(event: FeatureAContract.Event) {
        when (event) {
            FeatureAContract.Event.CreateRandomNumber -> createRandomNumber()
        }
    }

    /**
     * Create a random number
     */
    private fun createRandomNumber() {
        setState { copy(number = (1..100).random()) }
    }
}
