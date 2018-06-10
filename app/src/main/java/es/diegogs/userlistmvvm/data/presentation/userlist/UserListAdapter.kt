package es.diegogs.userlistmvvm.data.presentation.userlist

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import es.diegogs.userlistmvvm.R
import es.diegogs.userlistmvvm.data.model.UserEntity
import es.diegogs.userlistmvvm.data.model.UserEntityDiff
import kotlinx.android.synthetic.main.item_user.view.*

class UserListAdapter : ListAdapter<UserEntity, UserListAdapter.UserListViewHolder>(UserEntityDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(userEntity: UserEntity) {
            with(itemView) {
                userName.text = userEntity.name

                Glide.with(userAvatar)
                        .load(userEntity.avatarUrl)
                        .into(userAvatar)
            }
        }
    }
}