package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Observable

class UserFakeDataSource : UserDataSource {

    val userList = listOf(
            UserEntity(1, "Eloane", "https://randomuser.me/api/portraits/women/14.jpg"),
            UserEntity(2, "Luis", "https://randomuser.me/api/portraits/men/53.jpg"),
            UserEntity(3, "Bertha", "https://randomuser.me/api/portraits/women/37.jpg"),
            UserEntity(4, "Tommy", "https://randomuser.me/api/portraits/men/69.jpg")
    )

    override fun getUserList(): Observable<List<UserEntity>>
            = Observable.just(userList)

    override fun getUserDetail(userId: Long): Observable<UserEntity> =
            Observable.just(userList.find { it.userId == userId })
}