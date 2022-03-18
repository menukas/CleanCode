package com.amandrykin.cleancode.app

import android.app.Application
import com.amandrykin.cleancode.di.AppComponent
import com.amandrykin.cleancode.di.AppModule
import com.amandrykin.cleancode.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}