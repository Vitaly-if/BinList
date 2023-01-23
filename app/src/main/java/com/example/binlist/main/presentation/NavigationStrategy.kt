package com.example.binlist.main.presentation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface NavigationStrategy {

    fun navigate(supportFragmentManager: FragmentManager, containerId: Int)

    abstract class Abstract(protected open val screen: Screen) : NavigationStrategy {
        override fun navigate(supportFragmentManager: FragmentManager, containerId: Int) {
            supportFragmentManager.beginTransaction()
                .executeTransaction(containerId)
                .commit()
        }

        protected abstract fun FragmentTransaction.executeTransaction(
            containerId: Int,
        ): FragmentTransaction
    }

    data class Replace(override val screen: Screen) : Abstract(screen) {
        override fun FragmentTransaction.executeTransaction(containerId: Int): FragmentTransaction =
            replace(
                containerId,
                screen.fragment().newInstance(),
                screen.fragment().simpleName
            ).addToBackStack("FRAGMENT_TAG")
    }
}