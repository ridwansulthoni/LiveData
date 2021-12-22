package id.sulthoni.ridhwan.livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.sulthoni.ridhwan.livedata.model.DataUser

/**
 * Kelas UserAdaptor ini mengimplementasikan RecyclerView
 * Menggunakan metode yang mengambil data serta menambahkannya ke item daftar.
 * */
class UserAdaptor(
    private var mUser: DataUser
) : RecyclerView.Adapter<UserAdaptor.UserViewHolder>() {

    //Fungsi ini untuk membuat suatu tampilan dan mengembalikannya.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    //Fungsi ini menghubungkan data dengan view holder pada posisi yang ditentukan dalam RecyclerView.
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.id.text = mUser[position].id.toString()
        holder.name.text = mUser[position].name
        holder.email.text = mUser[position].email
        holder.username.text = mUser[position].username
        holder.phone.text = mUser[position].phone
    }

    //Fungsi ini untuk menghitung jumlah item data yang tersedia untuk ditampilkan.
    override fun getItemCount(): Int {
        return mUser.size
    }
    //RecyclerView.ViewHolder untuk membuat view holder bagi layout item
    class UserViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val id: TextView = containerView.findViewById(R.id.textView)
        val name: TextView = containerView.findViewById(R.id.textView2)
        val username: TextView = containerView.findViewById(R.id.textView3)
        val email: TextView = containerView.findViewById(R.id.textView4)
        val phone: TextView = containerView.findViewById(R.id.textView5)


    }

}