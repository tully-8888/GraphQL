package com.tully.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.tully.graphqlcountriesapp.CountriesQuery
import com.tully.graphqlcountriesapp.CountryQuery
import com.tully.graphqlcountriesapp.domain.CountryClient
import com.tully.graphqlcountriesapp.domain.DetailedCountry
import com.tully.graphqlcountriesapp.domain.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}