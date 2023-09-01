package cl.awakelab.sprintfinalm6.data.remote

data class PhoneDetail(
    val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean
)
