package com.tully.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.tully.graphqlcountriesapp.data.ApolloCountryClient
import com.tully.graphqlcountriesapp.domain.CountryClient
import com.tully.graphqlcountriesapp.domain.GetCountriesUseCase
import com.tully.graphqlcountriesapp.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideApolloClient():ApolloClient{
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient):CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient):GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }
    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient):GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }
}