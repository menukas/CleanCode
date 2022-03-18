package com.amandrykin.cleancode.di

import android.content.Context
import com.amandrykin.cleancode.domain.usecase.GetUserNameUseCase
import com.amandrykin.cleancode.domain.usecase.SaveUserNameUseCase
import com.amandrykin.cleancode.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ) : MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }
}