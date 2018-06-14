package es.diegogs.userlistmvvm.presentation.servicelocator

import android.content.SharedPreferences
import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource2

object Inject {

    lateinit var sharedPreferences: SharedPreferences

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()
    val userRepository = UserRepository(fakeDataSource, fakeDataSource2)

}