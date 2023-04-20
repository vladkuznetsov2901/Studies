fun main() {
    // Исходные данные
    val supplies = arrayOf(200, 350, 150) // Поставки
    val demands = arrayOf(100, 100, 80, 90, 70) // Требования
    val costs = arrayOf(
        intArrayOf(1, 4, 5, 3, 1),
        intArrayOf(2, 3, 1, 4, 2),
        intArrayOf(2, 1, 3, 1, 1)
    ) // Матрица стоимостей

    println("1. NorthWest algorithm: ")
    println("-------------------------------------------------------")

    val totalCost = northWestAlgorithm(supplies, demands, costs)

    println("-------------------------------------------------------")

    println("2. Optimize algorithm: ")

    println("-------------------------------------------------------")

    optimizeAlgorithm(supplies, demands, costs, totalCost)

    println("-------------------------------------------------------")



}

fun northWestAlgorithm(supplies:Array<Int>, demands:Array<Int>, costs: Array<IntArray>): Int {
    val numRows = supplies.size
    val numCols = demands.size

    val matrixNorthwest = Array(3) { IntArray(1) }

    // Создаем и заполняем таблицу решения
    var solution = Array(numRows) { IntArray(numCols) }
    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            val quantity = minOf(supplies[i], demands[j])
            solution[i][j] = quantity
            supplies[i] -= quantity
            demands[j] -= quantity
        }
    }
    var k = 0
    for (el in supplies) {
        if (el > 0) {
            matrixNorthwest[k][0] = el
            k += 1

        }
        else{
            matrixNorthwest[k][0] = 0
            k += 1
        }
    }


    val numRows2 = solution.size
    val numCols2 = solution[0].size + 1

    val result = Array(numRows2) { IntArray(numCols2) }

    // Объединяем две матрицы в одну
    for (i in 0 until numRows2) {
        for (j in 0 until numCols2 - 1) {
            result[i][j] = solution[i][j]

        }
    }

    for (i in 0 until numRows2) {
        result[i][result[0].size - 1] = matrixNorthwest[i][0]
    }


    // Выводим решение
    println("Решение транспортной задачи:")
    for (i in 0 until numRows2) {
        for (j in 0 until numCols2) {
            print("${result[i][j]}\t")
        }
        println()
    }


    // Выводим общую стоимость решения
    var totalCost = 0
    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            totalCost += solution[i][j] * costs[i][j]
        }
    }
    println("Общая стоимость решения: $totalCost")
    return totalCost
}

fun optimizeAlgorithm(supplies: Array<Int>, demands: Array<Int>, costs: Array<IntArray>, totalCost: Int){

    val numRows = supplies.size
    val numCols = demands.size

    var matrixOptimize = Array(numRows) { IntArray(numCols) }
    val suppliesOptimize = arrayOf(200, 350, 150) // Поставки
    val demandsOptimize = arrayOf(100, 100, 80, 90, 70) // Требования

    var min = costs[0][0]
    var max = costs[0][0]
    for (i in costs.indices){
        for (j in costs.indices){
            if (costs[i][j] < min){
                min = costs[i][j]
            }
            if (costs[i][j] > max){
                max = costs[i][j]
            }
        }

    }

    for (k in min..max){
        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                if (costs[i][j] == k){
                    val quantity = minOf(suppliesOptimize[i], demandsOptimize[j])
                    matrixOptimize[i][j] = quantity
                    suppliesOptimize[i] -= quantity
                    demandsOptimize[j] -= quantity
                }

            }
        }
    }



    println("Решение транспортной задачи:")
    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            print("${matrixOptimize[i][j]}\t")
        }
        println()
    }

    var totalCostOptimize = 0
    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            totalCostOptimize += matrixOptimize[i][j] * costs[i][j]
        }
    }
    println("Общая стоимость решения: $totalCostOptimize")

    println("$totalCostOptimize < $totalCost")

}






