package es.diegogs.userlistmvvm.presentation.userdetail

import android.arch.lifecycle.MutableLiveData
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.presentation.servicelocator.Inject
import es.diegogs.userlistmvvm.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserDetailViewModel : BaseViewModel() {

    val userState: MutableLiveData<UserEntity> = MutableLiveData()

    fun loadUserById(userId: Long) {
        Inject.userRepository.getUserDetail(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            userState.value = it
                        },
                        onError = {

                        }
                )
                .addTo(compositeDisposable)
    }
}