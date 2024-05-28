package com.makaraya.more.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.makaraya.more.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    private val _navigationEvent = MutableStateFlow<String?>(null)
    val navigationEvent: StateFlow<String?> get() = _navigationEvent

    companion object {
        const val RC_SIGN_IN = 9001
    }

    fun initGoogleSignInClient(client: GoogleSignInClient) {
        googleSignInClient = client
    }

    fun initFirebaseAuth(auth: FirebaseAuth) {
        firebaseAuth = auth
    }

    fun getGoogleSignIn() = googleSignInClient.signInIntent

    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Navigate to home screen if authentication is successful
                    viewModelScope.launch {
                        _navigationEvent.emit(Screen.Home.route)
                    }
                } else {
                    // Handle failed authentication
                }
            }
    }
}
