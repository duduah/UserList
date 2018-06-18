package es.diegogs.userlistmvvm.data.repository.datasource

import es.diegogs.userlistmvvm.data.mapper.UserEntityMapper
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.net.UserService
import io.reactivex.Flowable

class ApiDataSource(private val userService: UserService,
                    private val userEntityMapper: UserEntityMapper) : UserDataSource {

    override fun getUserList(): Flowable<List<UserEntity>> =
            userService.getUsers()
                    .map { it.results }
                    .map { userEntityMapper.transformList(it) }

}