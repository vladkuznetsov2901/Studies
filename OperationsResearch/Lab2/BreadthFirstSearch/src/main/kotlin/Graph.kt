class Graph {
    private data class Vertex(val name: String) {
        val neighbors = mutableSetOf<Vertex>()
    }

    private val vertices = mutableMapOf<String, Vertex>()

    private operator fun get(name: String) = vertices[name] ?: throw IllegalArgumentException()

    fun addVertex(name: String) {
        vertices[name] = Vertex(name)
    }

    private fun connect(first: Vertex, second: Vertex) {
        first.neighbors.add(second)
        second.neighbors.add(first)
    }

    fun connect(first: String, second: String) = connect(this[first], this[second])

    fun neighbors(name: String) = vertices[name]?.neighbors?.map { it.name } ?: listOf()

    fun useGraph() {
        val g = Graph()
        g.addVertex("q1")
        g.addVertex("q2")
        g.addVertex("q3")
        g.addVertex("q4")
        g.addVertex("q5")
        g.addVertex("q6")
        g.addVertex("q7")
        g.addVertex("q8")
        g.connect("q1", "C")
        g.connect("B", "D")
        g.connect("B", "C")
        println(g.neighbors("C"))
    }
// Должен получиться граф
// A ----- C
//         |
//         |
// D ----- B
//
}