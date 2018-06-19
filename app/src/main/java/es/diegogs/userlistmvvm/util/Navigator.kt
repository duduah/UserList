package es.diegogs.userlistmvvm.util

import android.app.Activity
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.presentation.userdetail.UserDetailActivity

class Navigator {

    fun openUserDetail(activity: Activity, userEntity: UserEntity) {
        activity.startActivity(UserDetailActivity.intent(activity, userEntity))
    }
}