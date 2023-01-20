package com.example.binlist.cards.presentation

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * @author Vitaly.N on 20.01.2023.
 */
sealed class UiState{
    abstract fun apply(inputLayout: TextInputLayout, textInputEditText: TextInputEditText)

    class Success : UiState() {

        override fun apply(
            inputLayout: TextInputLayout,
            textInputEditText: TextInputEditText
        ) = textInputEditText.setText("")
    }

    abstract class AbstractError(
        private val message: String,
        private val errorEnabled: Boolean
    ) : UiState() {

        override fun apply(
            inputLayout: TextInputLayout,
            textInputEditText: TextInputEditText
        ) = with(inputLayout) {
            isErrorEnabled = errorEnabled
            error = message
        }
    }

    data class ShowError(private val text: String) : AbstractError(text, true)
    class ClearError : AbstractError("", false)
}
