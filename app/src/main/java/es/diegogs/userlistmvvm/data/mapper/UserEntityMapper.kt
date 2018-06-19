package es.diegogs.userlistmvvm.data.mapper

import es.diegogs.userlistmvvm.data.model.User
import es.diegogs.userlistmvvm.data.model.UserEntity

class UserEntityMapper: Mapper<User, UserEntity> {

    override fun transform(input: User): UserEntity =
            UserEntity(0, input.name.last, input.picture.large)

    override fun transformList(inputList: List<User>): List<UserEntity> =
            inputList.map { transform(it) }
}