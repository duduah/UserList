package es.diegogs.userlistmvvm.data.db

import android.arch.persistence.room.*
import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Maybe

@Dao
abstract class UserDao {

    @Query("SELECT * FROM users")
    abstract fun getAllUsers(): Maybe<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(list: List<UserEntity>)

    @Query("DELETE FROM users")
    abstract fun deleteAllUsers()

    @Transaction
    open fun removeAndInsertUsers(users: List<UserEntity>) {
        deleteAllUsers()
        insertAll(users)
    }
}