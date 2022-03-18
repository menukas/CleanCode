package com.amandrykin.cleancode.di

import com.amandrykin.cleancode.domain.repository.UserRepository
import com.amandrykin.cleancode.domain.usecase.GetUserNameUseCase
import com.amandrykin.cleancode.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase {
    return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}