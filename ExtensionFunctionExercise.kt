class ExtensionFunctionExercise {
    fun main() {
        val titulo = readLine() ?: ""
        val autor = readLine() ?: ""

        // Aqui usamos a Extension Function "generateSlug()" nas Strings de Entrada.
        val slugTitulo = titulo.generateSlug()
        val slugAutor = autor.generateSlug()

        println("Slug gerado para o livro:")
        // Retorna a string nesse formato: nome-livro-separado-por-hifens_nome-autor-separado-por-hifens
        println(slugTitulo + "_"+ slugAutor)
    }

    fun String.generateSlug(): String {
        // Transforma a string em letras minúsculas, formata e retorna a string
        return toLowerCase().replace(" ", "-").replace(".", "")
    }
}