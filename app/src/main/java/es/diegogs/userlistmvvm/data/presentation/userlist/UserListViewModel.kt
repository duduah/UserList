package es.diegogs.userlistmvvm.data.presentation.userlist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.repository.UserRepository
import es.diegogs.userlistmvvm.data.repository.datasource.UserFakeDataSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserListViewModel : ViewModel() {

    // Para enviar la lista de usuarios a la vista:
    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()

    private val fakeDataSource = UserFakeDataSource()
    private val userRepository = UserRepository(fakeDataSource)

    fun loadUserList() {
        userRepository.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            userListState.value = it
                        },
                        onError = {

                        }
                )

    }
}