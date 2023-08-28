class SingletonExercise {
    class User(val id: Int, val name: String)

    /*
     * No Kotlin, a declaração de um objeto (por meio da palavra-chave object)
     * é uma maneira concisa e eficaz de implementar o padrão Singleton.
     */
    object UserManager {

        private val users = mutableListOf<User>()

        fun addUser(name: String) {
            users.add(User(users.size + 1, name))
        }

        fun listUsers() {
            users.forEach { println("${it.id} - ${it.name}") }
        }
    }

    fun main() {
        val quantity = readLine()?.toIntOrNull()!!

        for (i in 1..quantity) {
            val name = readLine() ?: ""!!
            UserManager.addUser(name)
        }

        UserManager.listUsers()
    }
}