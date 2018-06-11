package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Observable

class UserFakeDataSource2 : UserDataSource {


    val userList = listOf(
            UserEntity(1, "Gerry", "https://randomuser.me/api/portraits/men/7.jpg"),
            UserEntity(2, "Sarah", "https://randomuser.me/api/portraits/women/19.jpg")
    )

    override fun getUserList(): Observable<List<UserEntity>>
            = Observable.just(userList)

    override fun getUserDetail(userId: Long): Observable<UserEntity> =
            Observable.just(userList.find { it.userId == userId })
}



