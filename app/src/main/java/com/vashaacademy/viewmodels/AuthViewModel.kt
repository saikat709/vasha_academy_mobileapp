package com.vashaacademy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vashaacademy.session.AuthSession

class AuthViewModel: ViewModel() {
    private val _hasNetwork = MutableLiveData(false)
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private var _onError: ((msg:String) -> Unit)? = null

    var _session: AuthSession? = null

    private val _authToken = MutableLiveData("")
    val authToken: LiveData<String> = _authToken


    fun setSession(newSession: AuthSession){
        _session = newSession
    }

    fun setHasNetwork(hasNetwork: Boolean){
        _hasNetwork.value = hasNetwork
        if (_hasNetwork.value == false) _onError?.let { it("Network gone") }
    }

    fun setLoading(currentValue: Boolean){
        _isLoading.value = currentValue
    }

    fun setErrorListener( listenerFunc: (msg: String)->Unit ){
        _onError = listenerFunc
    }

    fun showError(msg: String){
        _onError?.let { it(msg) }
    }

    fun login(){

    }

}