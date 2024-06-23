    package com.makaraya.more.ui.screen.pendaftaran

    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import com.makaraya.more.data.AuthUserRepository
    import com.makaraya.more.data.model.User
    import com.makaraya.more.data.response.Resource
    import com.makaraya.more.network.DataResult
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.CoroutineScope
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.Job
    import kotlinx.coroutines.launch
    import kotlinx.coroutines.withContext
    import javax.inject.Inject

    @HiltViewModel
    class RegisterViewModel @Inject constructor(private val repository: AuthUserRepository) : ViewModel() {

        private var saveJob: Job? = null

        private val _savedUserStatus = MutableLiveData<Resource<String>>()
        val savedUserStatus: LiveData<Resource<String>> = _savedUserStatus

        fun saveUserData(user: User) {
            saveJob?.cancel()
            saveJob = CoroutineScope(Dispatchers.IO).launch {
                _savedUserStatus.postValue(Resource.loading(null))
                val result = repository.saveUser(user)
                withContext(Dispatchers.Main) {
                    when (result) {
                        is DataResult.Success -> {
                            val savedEmail = result.data.email // Adjust this based on your User model
                            _savedUserStatus.postValue(Resource.success(savedEmail, "Register Berhasil"))
                        }
                        is DataResult.Error -> {
                            _savedUserStatus.postValue(Resource.error(null, "Register Gagal"))
                        }
                    }
                }
            }
        }
    }