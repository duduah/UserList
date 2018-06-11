package es.diegogs.userlistmvvm.data.presentation.servicelocator

import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource2

object Inject {

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()
    val userRepository = UserRepository(fakeDataSource, fakeDataSource2)

}