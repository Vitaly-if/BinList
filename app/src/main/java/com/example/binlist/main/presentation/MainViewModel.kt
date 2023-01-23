package com.example.binlist.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.binlist.main.NavigationCommunication

/**
 * @author Vitaly.N on 18.01.2023.
 */
class MainViewModel(
    private val navigationCommunication: NavigationCommunication.Mutable,
) : ViewModel(), Init, Communication.Observe<NavigationStrategy> {

    override fun init(isFirstRun: Boolean) {
        if (isFirstRun)
            navigationCommunication.map(NavigationStrategy.Replace(Screen.Cards))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<NavigationStrategy>) {
        navigationCommunication.observe(owner, observer)
    }
}