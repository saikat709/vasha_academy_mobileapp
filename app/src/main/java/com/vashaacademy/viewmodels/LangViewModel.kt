package com.vashaacademy.viewmodels

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

object LangViewModel: ViewModel() {
    private val _isEnglish = MutableLiveData(true)
    val isEnglish : LiveData<Boolean> = _isEnglish


    private val KEY_IS_ENGLISH = booleanPreferencesKey("isEnglish")


    var dataStore: DataStore<Preferences>? = null

    fun setLangDataStore(newDataStore: DataStore<Preferences>){
        dataStore = newDataStore
    }


    fun setEnglish(){
        _isEnglish.value = true;
        viewModelScope.launch {
            saveLang()
        }
    }

    fun setBangla(){
        _isEnglish.value = false;
        viewModelScope.launch {
            saveLang()
        }
    }

    private suspend fun saveLang(){
        dataStore?.edit { preference ->
            preference[KEY_IS_ENGLISH] = _isEnglish.value!!
        }
    }

    suspend fun updateLangValue(){
        val res = dataStore?.data?.catch {
            emit(emptyPreferences())
        }?.map { preferences ->
            preferences[KEY_IS_ENGLISH] ?: false
        }
        _isEnglish.value = res?.first()
    }

}