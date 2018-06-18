package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Flowable

interface UserDataSource {

    fun getUserList(): Flowable<List<UserEntity>>

}