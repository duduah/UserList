package es.diegogs.userlistmvvm.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import es.diegogs.userlistmvvm.data.model.UserEntity
import io.reactivex.Flowable

@Dao
abstract class UserDao {

    @Query("SELECT * FROM users")
    abstract fun getAllUsers(): Flowable<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(list: List<UserEntity>)

    // TODO replace??
}