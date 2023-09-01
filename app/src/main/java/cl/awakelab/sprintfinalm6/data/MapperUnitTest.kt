import cl.awakelab.sprintfinalm6.data.remote.Phone
import cl.awakelab.sprintfinalm6.data.remote.PhoneDetail
import cl.awakelab.sprintfinalm6.data.toPhoneDetailEntity
import cl.awakelab.sprintfinalm6.data.toPhoneEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class MapperUnitTest {

    @Test
    fun testToPhoneEntity() {
        val phone = Phone(id = 1, name = "Phone X", price = 500, image = "phone_image_url")
        val phoneEntity = phone.toPhoneEntity()

        assertEquals(phone.id, phoneEntity.id)
        assertEquals(phone.name, phoneEntity.name)
        assertEquals(phone.price, phoneEntity.price)
        assertEquals(phone.image, phoneEntity.image)
    }

    @Test
    fun testToPhoneDetailEntity() {
        val phoneDetail = PhoneDetail(
            id = 1,
            name = "IPhone X",
            price = 345990,
            image = "phone_image_url",
            description = "This is a great phone.",
            lastPrice = 600000,
            credit = true
        )
        val phoneDetailEntity = phoneDetail.toPhoneDetailEntity()

        assertEquals(phoneDetail.id, phoneDetailEntity.id)
        assertEquals(phoneDetail.name, phoneDetailEntity.name)
        assertEquals(phoneDetail.price, phoneDetailEntity.price)
        assertEquals(phoneDetail.image, phoneDetailEntity.image)
        assertEquals(phoneDetail.description, phoneDetailEntity.description)
        assertEquals(phoneDetail.lastPrice, phoneDetailEntity.lastPrice)
        assertEquals(phoneDetail.credit, phoneDetailEntity.credit)
    }
}