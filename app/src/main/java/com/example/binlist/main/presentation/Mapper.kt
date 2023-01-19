package com.example.binlist.main.presentation

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface Mapper<R, S> {

    fun map(sourse: S): R

    interface Unit<S> : Mapper<kotlin.Unit, S>
}