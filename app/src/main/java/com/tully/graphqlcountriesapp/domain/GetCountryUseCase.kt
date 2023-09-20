package com.tully.graphqlcountriesapp.domain

import com.tully.graphqlcountriesapp.CountryQuery

///USE CASE USED FOR SINGLE RESPONSABILITY PRINCIPLE

class GetCountryUseCase (
    private val countryClient:CountryClient
){

    suspend fun execute(code:String):DetailedCountry?{
        return countryClient.getCountry(code)
    }
}