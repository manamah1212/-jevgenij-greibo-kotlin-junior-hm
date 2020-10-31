package common

data class Client(
    var name: String,
    var kids: Int,
    var salary: Double,
    var salaryNeto: Double? = null
)