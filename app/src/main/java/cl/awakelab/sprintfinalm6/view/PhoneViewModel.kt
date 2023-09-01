package cl.awakelab.sprintfinalm6.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.sprintfinalm6.data.Repository
import cl.awakelab.sprintfinalm6.data.local.PhoneDatabase
import cl.awakelab.sprintfinalm6.data.remote.PhoneRetrofit
import kotlinx.coroutines.launch

class PhoneViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Repository
    fun phoneLiveData() = repository.getPhoneEntity()

    fun phoneDetailLiveData(id: Int) = repository.getPhoneDetailEntity(id)
    init{
        val api = PhoneRetrofit.getRetrofitPhone()
        val phoneDatabase = PhoneDatabase.getDatabase(application).getPhoneDao()
        repository = Repository(api, phoneDatabase)
    }

    fun getPhones() = viewModelScope.launch {
        repository.getPhones()
    }

    fun getPhoneDetail(id: Int) = viewModelScope.launch{
        repository.getPhoneDetail(id)
    }
}
