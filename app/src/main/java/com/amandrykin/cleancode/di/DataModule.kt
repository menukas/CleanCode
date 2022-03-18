package com.amandrykin.cleancode.di

import android.content.Context
import com.amandrykin.cleancode.data.repository.UserRepositoryImpl
import com.amandrykin.cleancode.data.storage.UserStorage
import com.amandrykin.cleancode.data.storage.sharedprefs.SharedPrefUserStorage
import com.amandrykin.cleancode.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}