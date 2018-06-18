package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.db.UserDataBase
import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Flowable

class LocalDataSource(val userDatabase: UserDataBase) : UserDataSource {

    override fun getUserList(): Flowable<List<UserEntity>> =
            userDatabase
                    .getUserDao()
                    .getAllUsers()
}