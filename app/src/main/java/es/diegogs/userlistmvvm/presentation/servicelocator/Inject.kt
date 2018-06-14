package es.diegogs.userlistmvvm.presentation.servicelocator

import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource2
import es.diegogs.userlistmvvm.util.SettingsManager

object Inject {

    lateinit var settingsManager: SettingsManager

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()
    val userRepository = UserRepository(fakeDataSource, fakeDataSource2)

}