package id.sulthoni.ridhwan.livedata.network


import android.util.Log
import id.sulthoni.ridhwan.livedata.Results
import id.sulthoni.ridhwan.livedata.model.DataUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {

    val TAG: String = "Note"
    //Fungsi getUserDetails digunakan untuk menangkap sesuatu hasil
    fun getUserDetails(result: Results) {
        //fungsi call ini untuk memanggil data secara statis, dan berpotensi dari luar paket tempat kelas
        val call: Call<DataUser> = RetrofitProvider.getRetrofit().create(ApiInterface::class.java).getUser()

        /**
         *Digunakan untuk memanggil antrian permintaan secara asinkron
         *Dan beri tahu panggilan balik tentang responsnya atau jika terjadi kesalahan,membuat permintaan, atau memproses respons.
         */
        call.enqueue(object : Callback<DataUser> {
            override fun onResponse(
                call: Call<DataUser>,
                response: Response<DataUser>
            ) {
                val UserDataBody: DataUser? = response.body()
                result.sendResults(UserDataBody!!)
            }
            override fun onFailure(call: Call<DataUser>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }

        })
    }
}
/**
 * Buat objek retrofit dengan menggunakan GsonConverterFactory
 * URL untuk layanan web menggunakan dari https://jsonplaceholder.typicode.com/
 */
object RetrofitProvider {
    private var retrofit: Retrofit? = null
    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/").build()
        }
        return retrofit!!
    }
}