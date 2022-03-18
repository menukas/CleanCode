package com.amandrykin.cleancode.di

import com.amandrykin.cleancode.data.repository.UserRepositoryImpl
import com.amandrykin.cleancode.data.storage.UserStorage
import com.amandrykin.cleancode.data.storage.sharedprefs.SharedPrefUserStorage
import com.amandrykin.cleancode.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}