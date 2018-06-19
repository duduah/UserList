package es.diegogs.userlistmvvm.presentation

import android.app.Application
import com.facebook.stetho.Stetho
import es.diegogs.userlistmvvm.di.components.ApplicationComponent
import es.diegogs.userlistmvvm.di.components.DaggerApplicationComponent
import es.diegogs.userlistmvvm.di.modules.ApplicationModule

class UserApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        // DI
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()

    }
}