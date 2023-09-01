package cl.awakelab.sprintfinalm6.data.remote

import cl.awakelab.sprintfinalm6.view.PhoneDetailFragment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneAPI {
    @GET("products/")
    suspend fun getData(): Response<List<Phone>>

    @GET("details/{id}")
    suspend fun  getPhoneDetail(@Path("id") id: Int): Response<PhoneDetail>
}