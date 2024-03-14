package com.example.services.data

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}