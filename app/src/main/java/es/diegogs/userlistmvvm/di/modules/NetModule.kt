package es.diegogs.userlistmvvm.di.modules

import dagger.Module
import dagger.Provides
import es.diegogs.userlistmvvm.data.net.UserService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    fun provideUsersService(retrofit: Retrofit): UserService =
            retrofit.create(UserService::class.java)
}