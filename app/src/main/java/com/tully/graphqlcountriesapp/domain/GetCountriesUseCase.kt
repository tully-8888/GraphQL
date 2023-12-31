package com.tully.graphqlcountriesapp.domain

import com.tully.graphqlcountriesapp.CountryQuery

///USE CASE USED FOR SINGLE RESPONSABILITY PRINCIPLE

class GetCountriesUseCase (
    private val countryClient:CountryClient
){

    suspend fun execute():List<SimpleCountry>{
        return  countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}