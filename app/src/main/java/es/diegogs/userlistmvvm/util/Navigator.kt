package es.diegogs.userlistmvvm.util

import android.app.Activity
import android.content.Intent
import es.diegogs.userlistmvvm.presentation.userdetail.UserDetailActivity

object Navigator {

    fun openUserDetail(activity: Activity, userId: Long) {
        val intent = Intent(activity, UserDetailActivity::class.java)
        intent.putExtra(UserDetailActivity.PARAM_USER_ID, userId)
        activity.startActivity(intent)
    }
}