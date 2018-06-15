package es.diegogs.userlistmvvm.presentation.servicelocator

import es.diegogs.userlistmvvm.data.net.UserService
import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource2
import es.diegogs.userlistmvvm.util.SettingsManager
import okhttp3.OkHttpClient
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

    lateinit var settingsManager: SettingsManager

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()
    val userRepository = UserRepository(fakeDataSource, fakeDataSource2)

}