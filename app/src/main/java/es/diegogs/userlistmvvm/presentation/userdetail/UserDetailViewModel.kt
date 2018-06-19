package es.diegogs.userlistmvvm.presentation.userdetail

import android.arch.lifecycle.MutableLiveData
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.util.mvvm.BaseViewModel

class UserDetailViewModel : BaseViewModel() {

    val userState: MutableLiveData<UserEntity> = MutableLiveData()


}