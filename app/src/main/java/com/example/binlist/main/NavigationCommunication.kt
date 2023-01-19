package com.example.binlist.main

import com.example.binlist.main.presentation.Communication
import com.example.binlist.main.presentation.NavigationStrategy

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface NavigationCommunication {

    interface Observe : Communication.Observe<NavigationStrategy>

    interface Mutate : Communication.Mutate<NavigationStrategy>

    interface Mutable : Observe, Mutate

    class Base : Communication.SingleUi<NavigationStrategy>(), Mutable {
    }
}