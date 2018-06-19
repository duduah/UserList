package es.diegogs.userlistmvvm.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import es.diegogs.userlistmvvm.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}