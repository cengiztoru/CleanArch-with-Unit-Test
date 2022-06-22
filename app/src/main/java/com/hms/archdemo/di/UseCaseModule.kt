package com.hms.archdemo.di

import com.hms.archdemo.domain.use_case.FetchUsersUseCase
import com.hms.archdemo.domain.use_case.FetchUsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun provideFetchUsersUseCase(
        fetchUsersUseCaseImpl: FetchUsersUseCaseImpl
    ): FetchUsersUseCase
}
