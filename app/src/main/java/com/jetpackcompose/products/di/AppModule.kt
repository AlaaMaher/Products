package com.jetpackcompose.products.di

import com.jetpackcompose.products.store.data.remote.ProductsApi
import com.jetpackcompose.products.store.presentation.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideProductApi():ProductsApi{
        return Retrofit.Builder()
            .baseUrl(Constant.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)


    }
}