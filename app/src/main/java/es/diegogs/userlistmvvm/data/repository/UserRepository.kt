package es.diegogs.userlistmvvm.data.repository

import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import io.reactivex.Observable

class UserRepository(private val userFakeDataSource: UserFakeDataSource) {

    fun getUserList(): Observable<List<UserEntity>> =
            userFakeDataSource.getUserList()

    fun getUserDetail(userId: Long): Observable<UserEntity> =
            userFakeDataSource.getUserDetail(userId)
}