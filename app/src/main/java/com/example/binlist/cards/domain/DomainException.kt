package com.example.binlist.cards.domain

/**
 * @author Vitaly.N on 20.01.2023.
 */
abstract class DomainException : IllegalStateException()

class NoInternetConnectionException : DomainException()

class ServiceUnavailableException : DomainException()