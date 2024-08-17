package br.com.natura.conecta.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.loginDataStore: DataStore<Preferences> by preferencesDataStore(name = "login")
val userPreferences = stringPreferencesKey("userLogged")

val Context.onBoardingDataStore: DataStore<Preferences> by preferencesDataStore(name = "welcome")
val onBoardingPreferences = booleanPreferencesKey("onBoardingFinished")