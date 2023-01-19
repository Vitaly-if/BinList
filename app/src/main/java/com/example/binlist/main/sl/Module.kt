package com.example.binlist.main.sl

import androidx.lifecycle.ViewModel

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface Module<T : ViewModel> {

    fun viewModel(): T

}