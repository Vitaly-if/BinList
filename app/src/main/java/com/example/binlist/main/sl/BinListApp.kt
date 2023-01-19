package com.example.binlist.main.sl

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @author Vitaly.N on 18.01.2023.
 */
class BinListApp : Application(), ProvideViewModel {
    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var dependencyContainer: DependencyContainer.Base
    override fun onCreate() {
        super.onCreate()
        dependencyContainer = DependencyContainer.Base(Core.Base(this))
        viewModelsFactory = ViewModelsFactory(dependencyContainer)
    }
    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
      ViewModelProvider(owner, viewModelsFactory)[clazz]

}