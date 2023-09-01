package cl.awakelab.sprintfinalm6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhoneDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhone(phoneEntity: List<PhoneEntity>)

    @Query("Select * from table_phones order by id asc")
    fun getPhones(): LiveData<List<PhoneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoneDetail(phoneDetailEntity: PhoneDetailEntity)

    @Query("Select * from table_detail_phones where id = :id")
    fun getPhoneDetail(id: Int): LiveData<PhoneDetailEntity>

}
