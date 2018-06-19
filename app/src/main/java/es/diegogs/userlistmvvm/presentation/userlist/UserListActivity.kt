package es.diegogs.userlistmvvm.presentation.userlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import es.diegogs.userlistmvvm.R
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.presentation.UserApp
import es.diegogs.userlistmvvm.presentation.userdetail.UserDetailActivity
import es.diegogs.userlistmvvm.util.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserListActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var userListViewModel: UserListViewModel

    private val adapter = UserListAdapter{ onUserClicked(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecycler()
        setUpViewModel()
    }

    private fun inject() {
        (application as UserApp).component.inject(this)
    }

    private fun setUpRecycler() {
        userListRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        userListRecycler.itemAnimator = DefaultItemAnimator()
        userListRecycler.adapter = adapter
    }

    private fun setUpViewModel() {
        userListViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserListViewModel::class.java)
        bindEvents()
        userListViewModel.loadUserList()
    }

    private fun bindEvents() {
        userListViewModel.isLoadingState.observe(this, Observer { isLoading ->
            isLoading?.let {
                showLoading(it)
            }
        })

        userListViewModel.userListState.observe(this, Observer { userList ->
            userList?.let {
                onUserListLoaded(it)
            }
        })
    }

    private fun onUserListLoaded(userList: List<UserEntity>) {
        adapter.submitList(userList)
    }

    private fun showLoading(isLoading: Boolean) {
        userListLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun onUserClicked(userEntity: UserEntity) {
        navigator.openUserDetail(this, userEntity)
    }

}
