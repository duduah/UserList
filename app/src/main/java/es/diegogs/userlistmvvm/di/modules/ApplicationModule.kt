package es.diegogs.userlistmvvm.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import es.diegogs.userlistmvvm.util.Navigator
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = Navigator()
}