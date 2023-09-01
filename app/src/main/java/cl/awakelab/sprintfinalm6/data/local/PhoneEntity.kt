package cl.awakelab.sprintfinalm6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_phones")
data class PhoneEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Int,
    val image: String
)
