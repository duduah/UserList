package es.diegogs.userlistmvvm.data.repository

import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.repository.datasource.ApiDataSource
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserRepository(private val apiDataSource: ApiDataSource) {

    fun getUserList(): Flowable<List<UserEntity>> =
            apiDataSource.getUserList()
                    .delay(1, TimeUnit.SECONDS)

}