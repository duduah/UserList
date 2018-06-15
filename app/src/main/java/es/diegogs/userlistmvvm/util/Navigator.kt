package es.diegogs.userlistmvvm.util

import android.app.Activity
import es.diegogs.userlistmvvm.presentation.userdetail.UserDetailActivity

object Navigator {

    fun openUserDetail(activity: Activity, userId: Long) {
        activity.startActivity(UserDetailActivity.intent(activity, userId))
    }
}