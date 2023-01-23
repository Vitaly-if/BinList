package com.example.binlist.cards.domain

import retrofit2.HttpException

/**
 * @author Vitaly.N on 20.01.2023.
 */
abstract class DomainException : IllegalStateException()

class NoInternetConnectionException : DomainException()
