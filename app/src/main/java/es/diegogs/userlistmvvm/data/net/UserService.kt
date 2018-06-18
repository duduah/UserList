package es.diegogs.userlistmvvm.data.net

import es.diegogs.userlistmvvm.data.model.UserApiResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface UserService {

    @GET("api/?results=20")
    fun getUsers(): Flowable<UserApiResponse>
}