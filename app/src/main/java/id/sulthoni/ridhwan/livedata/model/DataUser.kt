package id.sulthoni.ridhwan.livedata.model

//Kelas DataUser mengimplemtasikan fungsi Arraylist yang diambil dari ItemData
class DataUser : ArrayList<ItemData>()

/**
 * Kelas ItemData digunakan untuk menampung data
 * Data yang ditampung disini dideklarasikan atribut dan parameternya
 * Nama atribut pada kelas data di gunakan untuk mencocokkan nama nilai di json
 */
data class ItemData(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String
)