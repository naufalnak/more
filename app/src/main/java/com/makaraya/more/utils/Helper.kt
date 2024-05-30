package com.makaraya.more.utils

import android.content.Context
import android.content.SharedPreferences
import com.makaraya.more.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Peta.route,
        Screen.Riwayat.route,
        Screen.Profil.route
    )
}

object PreferenceHelper {
    private const val PREFERENCES_NAME = "onboarding_prefs"
    private const val KEY_ONBOARDING_COMPLETE = "onboarding_complete"

    fun setOnboardingComplete(context: Context, isComplete: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(KEY_ONBOARDING_COMPLETE, isComplete).apply()
    }

    fun isOnboardingComplete(context: Context): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(KEY_ONBOARDING_COMPLETE, false)
    }
}