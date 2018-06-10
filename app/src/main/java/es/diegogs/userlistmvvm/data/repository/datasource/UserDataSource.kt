package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Observable

interface UserDataSource {

    fun getUserList(): Observable<List<UserEntity>>
    fun getUserDetail(userId: Long): Observable<UserEntity>

}