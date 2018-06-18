package es.diegogs.userlistmvvm.presentation

import android.app.Application
import android.preference.PreferenceManager
import com.facebook.stetho.Stetho
import es.diegogs.userlistmvvm.presentation.servicelocator.Inject
import es.diegogs.userlistmvvm.util.SettingsManager

class UserApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        Inject.initDatabase(this)

        Inject.settingsManager = SettingsManager(PreferenceManager.getDefaultSharedPreferences(this))
    }
}