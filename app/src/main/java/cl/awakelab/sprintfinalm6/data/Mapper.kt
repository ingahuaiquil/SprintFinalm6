package cl.awakelab.sprintfinalm6.data

import cl.awakelab.sprintfinalm6.data.local.PhoneDetailEntity
import cl.awakelab.sprintfinalm6.data.local.PhoneEntity
import cl.awakelab.sprintfinalm6.data.remote.Phone
import cl.awakelab.sprintfinalm6.data.remote.PhoneDetail

fun Phone.toPhoneEntity(): PhoneEntity {
    return PhoneEntity(
        id = this.id,
        name = this.name,
        price = this.price,
        image = this.image
    )
}

fun PhoneDetail.toPhoneDetailEntity(): PhoneDetailEntity{
    return PhoneDetailEntity(
        id = this.id,
        name = this.name,
        price = this.price,
        image = this.image,
        description = this.description,
        lastPrice = this.lastPrice,
        credit = this.credit
    )
}

