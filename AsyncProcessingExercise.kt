class AsyncProcessingExercise {
    fun main() {
        val urls = mutableListOf<String>()

        while (true) {
            val input = readLine() ?: break
            if (input.isBlank()) break
            urls.add(input)
        }

        println("Iniciando downloads...")

        // Cria uma lista de Pair (indice, tamanho)
        val results = mutableListOf<Pair<Int, Int>>()

        val threads = urls.mapIndexed { index, url ->
            Thread {
                val length = openLink(url)
                // synchronized garante que cada url pegue somente um valor por vez
                synchronized(results) {
                    results.add(Pair(index, length))
                }
            }
        }

        // Inicia as threads
        threads.forEach { it.start() }

        // Aguarda até que todas as threads tenham concluído sua execução
        threads.forEach { it.join() }

        // Classifica os resultados por índice para imprimir na ordem correta
        results.sortedBy { it.first }.forEachIndexed { idx, result ->
            println("Arq${idx + 1}: ${result.second}")
        }

        println("Tempo total: ${urls.size}")
    }

    fun openLink(url: String): Int {
        return url.length
    }
}