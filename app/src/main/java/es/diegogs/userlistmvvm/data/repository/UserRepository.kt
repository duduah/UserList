package es.diegogs.userlistmvvm.data.repository

import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource2
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserRepository(private val userFakeDataSource: UserFakeDataSource,
                     private val userFakeDataSource2: UserFakeDataSource2) {

    fun getUserList(): Observable<List<UserEntity>> =
            userFakeDataSource.getUserList()
                    .concatWith(userFakeDataSource2.getUserList())
                    .delay(1, TimeUnit.SECONDS)

    fun getUserDetail(userId: Long): Observable<UserEntity> =
            userFakeDataSource.getUserDetail(userId)
                    .switchIfEmpty(userFakeDataSource2.getUserDetail(userId))
                    .delay(1, TimeUnit.SECONDS)
}