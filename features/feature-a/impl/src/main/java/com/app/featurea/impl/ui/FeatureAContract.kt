package com.app.featurea.impl.ui

import com.app.core.mvi.models.UIEffect
import com.app.core.mvi.models.UIEvent
import com.app.core.mvi.models.UIState

/**
 * Feature A contract
 */
class FeatureAContract {

    sealed class Event : UIEvent {
        /**
         * Create random number event
         */
        data object CreateRandomNumber : Event()

        /**
         * Show SnackBar
         */
        data object ShowSnackBar : Event()
    }

    /**
     * State
     *
     * @property number number to show
     */
    data class State(val number: Int) : UIState

    sealed class Effect : UIEffect {
        /**
         * Show SnackBar event
         */
        data object ShowSnackBar : Effect()
    }
}
