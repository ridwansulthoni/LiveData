package id.sulthoni.ridhwan.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.sulthoni.ridhwan.livedata.model.DataUser
import id.sulthoni.ridhwan.livedata.network.ApiService

class MainActivity : AppCompatActivity(), Results {
    //lateinit memungkinkan mengalihkan inisialisasi properti secara cepat
    lateinit var adapter: UserAdaptor
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ApiService().getUserDetails(this)
    }

    override fun sendResults(user: DataUser) {
        adapter = UserAdaptor(user)
        recyclerView = findViewById(R.id.recyclerView)
        adapter.also { it.also { it.also { recyclerView.adapter = it } } }
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}
/**
 * Mengimplemtasikan kelas Results dengan interface
 * Kelas ini digunakan untuk mengekspos metode sendResults
 */
interface Results {
    fun sendResults(user: DataUser)
}