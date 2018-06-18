package es.diegogs.userlistmvvm.presentation.servicelocator

import es.diegogs.userlistmvvm.data.mapper.UserEntityMapper
import es.diegogs.userlistmvvm.data.net.UserService
import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.ApiDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import es.diegogs.userlistmvvm.util.SettingsManager
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Inject {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    val userService = retrofit.create(UserService::class.java)

    val userEntityMapper = UserEntityMapper()

    lateinit var settingsManager: SettingsManager

    val fakeDataSource = UserFakeDataSource()
    val apiDataSource = ApiDataSource(userService, userEntityMapper)

    val userRepository = UserRepository(apiDataSource)

}