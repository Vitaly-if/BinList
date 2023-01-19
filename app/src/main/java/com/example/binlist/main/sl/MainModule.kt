package com.example.binlist.main.sl

import com.example.binlist.main.presentation.MainViewModel

/**
 * @author Vitaly.N on 18.01.2023.
 */
class MainModule(private val core: Core) : Module<MainViewModel> {
    override fun viewModel() = MainViewModel(
        core.provideNavigation()
    )
}