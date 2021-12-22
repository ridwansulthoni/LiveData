package id.sulthoni.ridhwan.livedata.network

import id.sulthoni.ridhwan.livedata.model.DataUser
import retrofit2.Call
import retrofit2.http.GET

/**
 * Mengimplemtasikan kelas ApiInterface dengan interface
 * Kelas ini digunakan untuk mengekspos metode getUser
 */
interface ApiInterface {
    /**
     *Retrofit untuk menampilkan daftar objek User dari array JSON
     *Dengan menggunakan @GET untuk memberi tahukan Retrofit
     *Bahwa ini adalah sebuah permintaan
     */
    @GET("users")
    fun getUser(): Call<DataUser>
}