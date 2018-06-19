package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.db.UserDataBase
import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class LocalDataSource(val userDatabase: UserDataBase) : UserDataSource {

    override fun getUserList(): Flowable<List<UserEntity>> =
            userDatabase
                    .getUserDao()
                    .getAllUsers()
                    .toFlowable()

    fun saveUsers(users: List<UserEntity>) {
        Observable.fromCallable {
            userDatabase.getUserDao().removeAndInsertUsers(users)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}