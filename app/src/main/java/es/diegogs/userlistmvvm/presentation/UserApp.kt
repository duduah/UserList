package es.diegogs.userlistmvvm.presentation

import android.app.Application
import android.preference.PreferenceManager
import es.diegogs.userlistmvvm.presentation.servicelocator.Inject

class UserApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Inject.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    }
}