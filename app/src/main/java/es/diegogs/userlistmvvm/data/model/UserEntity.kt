package es.diegogs.userlistmvvm.data.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserEntity(
        val name: String,
        val avatarUrl: String
): Parcelable