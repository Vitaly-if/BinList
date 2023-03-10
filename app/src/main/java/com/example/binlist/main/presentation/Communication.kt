package com.example.binlist.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface Communication {
    interface Observe<T> {
        fun observe(owner: LifecycleOwner, observer: Observer<T>)
    }

    interface Mutate<T> : Mapper.Unit<T>

    interface Mutable<T> : Observe<T>, Mutate<T>

    abstract class Abstract<T>(
        protected val liveData: MutableLiveData<T> = MutableLiveData(),
    ) : Mutable<T> {
        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            liveData.observe(owner, observer)
        }
    }

    abstract class Ui<T>(
        liveData: MutableLiveData<T> = MutableLiveData(),
    ) : Abstract<T>(liveData) {
        override fun map(sourse: T) {
            liveData.value = sourse
        }
    }

    abstract class Post<T>(
        liveData: MutableLiveData<T> = MutableLiveData(),
    ) : Abstract<T>(liveData) {
        override fun map(sourse: T) = liveData.postValue(sourse)
    }

    abstract class SingleUi<T> : Ui<T>(SingleLifeEvent())
}