package com.amandrykin.cleancode.di

import com.amandrykin.cleancode.domain.usecase.GetUserNameUseCase
import com.amandrykin.cleancode.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}