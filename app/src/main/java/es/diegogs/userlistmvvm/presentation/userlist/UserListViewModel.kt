package es.diegogs.userlistmvvm.presentation.userlist

import android.arch.lifecycle.MutableLiveData
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.presentation.servicelocator.Inject
import es.diegogs.userlistmvvm.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserListViewModel : BaseViewModel() {

    companion object {
        const val PREF_FIRST_LOAD = "PREF_FIRST_LOAD"
    }

    // Para enviar la lista de usuarios a la vista:
    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()


    fun loadUserList() {
        Inject.userRepository.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoadingState.postValue(true)}
                .doOnTerminate { isLoadingState.postValue(false)}
                .subscribeBy(
                        onNext = {
                            userListState.value = it
                        },
                        onError = {

                        },
                        onComplete = {
                            Inject.sharedPreferences.edit()
                                    .putBoolean(PREF_FIRST_LOAD, false)
                                    .apply()
                        }
                )
                .addTo(compositeDisposable)

    }
}