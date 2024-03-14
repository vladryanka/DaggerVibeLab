package com.example.services.data

import com.example.services.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectsMainActivity( mainActivity: MainActivity)
    fun inject(view: View)
    fun inject(worker: CatWorker)
    fun inject(provider: Provider)
}