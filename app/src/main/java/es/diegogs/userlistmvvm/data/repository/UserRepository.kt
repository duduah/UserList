package es.diegogs.userlistmvvm.data.repository

import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.repository.datasource.ApiDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.LocalDataSource
import io.reactivex.Flowable

class UserRepository(private val localDataSource: LocalDataSource,
                     private val apiDataSource: ApiDataSource) {

    fun getUserList(): Flowable<List<UserEntity>> =
            getUsersFromDb()
                    .concatWith(getUsersFromApi())


    private fun getUsersFromDb(): Flowable<List<UserEntity>> = localDataSource.getUserList()

    private fun getUsersFromApi(): Flowable<List<UserEntity>> =
            apiDataSource.getUserList()
                    .doOnNext{ localDataSource.saveUsers(it) }
}