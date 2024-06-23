package com.makaraya.more.data

import android.content.Context
import com.makaraya.more.data.model.User
import com.makaraya.more.network.ApiInterface
import com.makaraya.more.network.safeApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthUserRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private val apiInterface = ApiInterface.invoke()

    suspend fun saveUser(user: User) = safeApiCall { apiInterface.saveUser(user) }
}