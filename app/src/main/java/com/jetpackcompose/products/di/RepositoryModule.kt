package com.jetpackcompose.products.di

import com.jetpackcompose.products.store.data.repository.ProductsRepositoryImpl
import com.jetpackcompose.products.store.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl: ProductsRepositoryImpl):ProductsRepository
}