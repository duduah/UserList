package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable

class UserFakeDataSource : UserDataSource {

    val userList = listOf(
            UserEntity("Eloane", "https://randomuser.me/api/portraits/women/14.jpg"),
            UserEntity("Luis", "https://randomuser.me/api/portraits/men/53.jpg"),
            UserEntity("Bertha", "https://randomuser.me/api/portraits/women/37.jpg"),
            UserEntity("Tommy", "https://randomuser.me/api/portraits/men/69.jpg")
    )

    override fun getUserList(): Flowable<List<UserEntity>>
            = Flowable.just(userList)

}