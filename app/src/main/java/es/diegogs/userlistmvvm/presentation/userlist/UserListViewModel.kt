package es.diegogs.userlistmvvm.presentation.userlist

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.presentation.servicelocator.Inject
import es.diegogs.userlistmvvm.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserListViewModel : BaseViewModel() {

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
                            Log.d("UserViewModel", it.toString())
                        },
                        onComplete = {
                            Inject.settingsManager.firstLoad = false
                        }
                )
                .addTo(compositeDisposable)

    }
}