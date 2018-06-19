package es.diegogs.userlistmvvm.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import es.diegogs.userlistmvvm.data.db.UserDataBase
import es.diegogs.userlistmvvm.data.mapper.UserEntityMapper
import es.diegogs.userlistmvvm.data.net.UserService
import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.ApiDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.LocalDataSource
import es.diegogs.userlistmvvm.util.SettingsManager

@Module
class DataModule {

    @Provides
    fun provideUserEntityMapper(): UserEntityMapper = UserEntityMapper()

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun provideSettingsManager(sharedPreferences: SharedPreferences): SettingsManager =
            SettingsManager(sharedPreferences)

    @Provides
    fun provideDatabase(context: Context): UserDataBase =
            Room.databaseBuilder(context, UserDataBase::class.java, "user.db").build()

    @Provides
    fun provideLocalDataSource(userDataBase: UserDataBase): LocalDataSource =
            LocalDataSource(userDataBase)

    @Provides
    fun provideApiDataSource(userService: UserService,
                             userEntityMapper: UserEntityMapper): ApiDataSource =
            ApiDataSource(userService, userEntityMapper)

    @Provides
    fun provideUserRepository(localDataSource: LocalDataSource,
                              apiDataSource: ApiDataSource): UserRepository =
            UserRepository(localDataSource, apiDataSource)

}