import kotlin.math.pow

class Alphabet {

    fun createAlphabet(): MutableMap<Char, Int> {
        println("Enter the word: ")
        val alphabet = readln()

        val map = mutableMapOf<Char, Int>()
        for (i in (alphabet.indices)) {
            map[alphabet[i]] = i + 1
        }
        return map
    }

    private fun getKey(alphabet: MutableMap<Char, Int>, value: Int): Any {
        for ((k, v) in alphabet) {
            if (v == value) return k
        }
        return "NaN"
    }

    fun searchNumber(alphabet: MutableMap<Char, Int>, word: String): Int {


        var cnt = 0
        var num: Any

        for (i in word.indices) {
            if (word[i] in alphabet) {
                num = alphabet[word[i]]!!
                val a = alphabet.size
                val b = word.length - i - 1
                println()
                cnt += (a.toDouble().pow(b).toInt()) * num
                println(cnt)
            } else return 0
        }

        return cnt
    }

    fun searchAlpha(alphabet: MutableMap<Char, Int>, ind: Int): String {
        val word = arrayListOf<String>()
        var ind2 = ind
        var tail: Int
        while (ind2 > 0) {
            tail = ind2 % alphabet.size
            if (tail == 0) {
                ind2 -= 1
                word.add(0, alphabet.keys.last().toString())
            } else {
                word.add(0, getKey(alphabet, tail).toString())
            }

            ind2 /= alphabet.size
        }
        return "$word"
    }

    fun lab2(alphabet: MutableMap<Char, Int>) {

        var l = 30

        var i = 1

        var cnt = 0

        var str: String

        while (l != 0) {
            str = searchAlpha(alphabet, i)
            for (j in str) {
                if (j == '1') {
                    cnt += 1
                }
            }
            if (cnt != 0 && cnt % 2 == 0) {
                println(searchAlpha(alphabet, i))
                l -= 1
            }
            cnt = 0
            i += 1
        }

    }

    fun lab2_2(alphabet: MutableMap<Char, Int>) {

        var l = 30

        var i = 1

        var cnt = 0

        var str: String

        while (l != 0) {
            str = searchAlpha(alphabet, i)
            for (j in str) {
                if (j == '0') {
                    cnt += 1
                }
            }
            if (cnt != 0 && cnt % 3 == 0) {
                println(searchAlpha(alphabet, i))
                l -= 1
            }
            cnt = 0
            i += 1
        }

    }

}