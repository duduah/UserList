package es.diegogs.userlistmvvm.di.components

import dagger.Component
import es.diegogs.userlistmvvm.di.modules.ApplicationModule
import es.diegogs.userlistmvvm.di.modules.DataModule
import es.diegogs.userlistmvvm.di.modules.NetModule
import es.diegogs.userlistmvvm.presentation.userlist.UserListActivity


@Component(modules = [ApplicationModule::class, NetModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(userListActivity: UserListActivity)
}