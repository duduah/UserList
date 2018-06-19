package es.diegogs.userlistmvvm.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import es.diegogs.userlistmvvm.util.Navigator

@Module
class ApplicationModule(val application: Application) {

    @Provides
    fun provideContext(): Context = application.applicationContext

    @Provides
    fun provideNavigator(): Navigator = Navigator()
}