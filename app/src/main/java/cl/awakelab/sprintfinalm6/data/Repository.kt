package cl.awakelab.sprintfinalm6.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.sprintfinalm6.data.local.PhoneDetailEntity
import cl.awakelab.sprintfinalm6.data.local.PhoneDao
import cl.awakelab.sprintfinalm6.data.local.PhoneEntity
import cl.awakelab.sprintfinalm6.data.remote.PhoneAPI

class Repository(private val phoneAPI: PhoneAPI, private val phoneDao: PhoneDao) {
    fun getPhoneEntity(): LiveData<List<PhoneEntity>> = phoneDao.getPhones()

    fun getPhoneDetailEntity(id: Int): LiveData<PhoneDetailEntity> =
        phoneDao.getPhoneDetail(id)

    suspend fun getPhones() {

        val response = phoneAPI.getData()
        if (response.isSuccessful) {

            val phones = response.body()
            if (phones != null) {
                val phoneEntities = phones.map { it.toPhoneEntity() }
                phoneDao.insertPhone(phoneEntities)

            } else {
                Log.e("repository", response.errorBody().toString())
            }
        }

    }

     suspend fun getPhoneDetail(id: Int)  {
        try {
            val response = phoneAPI.getPhoneDetail(id)
            Log.e("repository", "response")
            if (response.isSuccessful) {
                val phoneDetail = response.body()
                if (phoneDetail != null) {
                    Log.e("repository", "$phoneDetail")
                    val phoneEntity = phoneDetail.toPhoneDetailEntity()
                    phoneDao.insertPhoneDetail(phoneEntity)
                } else {
                    Log.e("repository", "Error getting phone detail: Response body is null")
                }
            } else {
                Log.e("repository", "Error getting phone detail: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.e("repository", "Exception while getting phone detail: ${e.message}")
        }

    }
}