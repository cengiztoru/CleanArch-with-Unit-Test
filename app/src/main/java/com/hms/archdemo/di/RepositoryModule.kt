package com.hms.archdemo.di

import com.hms.archdemo.data.repository.UsersRepositoryImpl
import com.hms.archdemo.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUsersRepository(
        usersRepositoryImpl: UsersRepositoryImpl
    ): UsersRepository
}