package com.tully.graphqlcountriesapp.data

import com.tully.graphqlcountriesapp.CountriesQuery
import com.tully.graphqlcountriesapp.CountryQuery
import com.tully.graphqlcountriesapp.domain.DetailedCountry
import com.tully.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry():DetailedCountry{
    return DetailedCountry(
        code=code,
        name = name,
        emoji = emoji,
        capital = capital?:"Unknown",
        currency = currency?:"Unknown",
        languages = languages.mapNotNull { it.name },
        continent=continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry():SimpleCountry{
    return SimpleCountry(
        code=code,
        name = name,
        emoji = emoji,
        capital = capital?:"Unknown"
    )
}