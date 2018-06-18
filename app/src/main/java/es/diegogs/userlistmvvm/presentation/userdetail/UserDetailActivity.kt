package es.diegogs.userlistmvvm.presentation.userdetail

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import es.diegogs.userlistmvvm.R
import es.diegogs.userlistmvvm.data.model.UserEntity
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity: AppCompatActivity() {

    companion object {
        const val PARAM_USER_ID = "PARAM_USER_ID"

        fun intent(context: Context, userEntity: UserEntity): Intent {
            val detailIntent = Intent(context, UserDetailActivity::class.java)
            detailIntent.putExtra(PARAM_USER_ID, userEntity)
            return detailIntent
        }
    }

    lateinit var userDetailViewModel: UserDetailViewModel
    var userEntity: UserEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_user_detail)

        userEntity = intent.getParcelableExtra(PARAM_USER_ID)
        init()
    }

    private fun init() {
        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        loadUserData()
    }

    private fun onUserLoaded(userEntity: UserEntity) {
        userDetailName.text = userEntity.name

        Glide.with(this)
                .load(userEntity.avatarUrl)
                .into(userDetailAvatar)
    }

    private fun loadUserData() {

        if (userEntity == null) {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        onUserLoaded(userEntity!!)
    }
}