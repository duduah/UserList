package es.diegogs.userlistmvvm.di.components

import dagger.Component
import es.diegogs.userlistmvvm.di.modules.ApplicationModule
import es.diegogs.userlistmvvm.di.modules.DataModule
import es.diegogs.userlistmvvm.di.modules.NetModule
import es.diegogs.userlistmvvm.presentation.userlist.UserListActivity
import es.diegogs.userlistmvvm.util.mvvm.ViewModelModule


@Component(modules = [
    ApplicationModule::class,
    NetModule::class,
    DataModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(userListActivity: UserListActivity)
}