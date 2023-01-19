package com.example.binlist.main.sl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface ProvideViewModel {
    fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T
}