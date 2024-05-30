package com.makaraya.more.ui.screen.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

//class SignOutViewModel : ViewModel() {
//    private val _isSignOutSuccessful = MutableStateFlow(false)
//    val isSignOutSuccessful: StateFlow<Boolean> = _isSignOutSuccessful
//
//    fun signOut(oneTapClient: OneTapClient, auth: FirebaseAuth) {
//        viewModelScope.launch {
//            try {
//                oneTapClient.signOut().await()
//                auth.signOut()
//                _isSignOutSuccessful.value = true
//            } catch(e: Exception) {
//                e.printStackTrace()
//                if(e is CancellationException) throw e
//                _isSignOutSuccessful.value = false
//            }
//        }
//    }
//
//    fun resetState() {
//        _isSignOutSuccessful.value = false
//    }
//}