package pgs.lv1

// 중요한 단어를 스포방지(코틀린버전)
/**
 * 스포일러 범위의 단어(단어 시작 <= 스포일러 끝 && 단어 끝 >= 스포 시작) 들을 구함. 스포일러 범위가 아닌 단어들을 구함
 * 스포일러 단어 리스트 중, 스포일러 '아닌' 단어 리스트 와 중복되지 않는 단어만 스포일러 단어로 카운트.
 */
class PGS_468370_retry {

    data class Word(
        val word: String,
        val start: Int,
        val end: Int,
        var isSpoiler: Boolean = false,
    ){
        fun markSpoiler(ranges: Array<IntArray>) {
            isSpoiler = ranges.any{ (s, e) -> s <= end && start <= e}
        }
    }

    fun solution(message: String, spoiler_ranges: Array<IntArray>): Int {
        val words = splitWithIndex(message)
        words.forEach { it.markSpoiler(spoiler_ranges) }

        val openWords = words.filter { !it.isSpoiler}.map { it.word }.toSet()

        return words.filter { it.isSpoiler }
            .map{it.word}
            .filter { it !in openWords }
            .toSet()
            .size
    }

    fun splitWithIndex(s: String): List<Word> {
        val result = mutableListOf<Word>()
        var i = 0
        while(i < s.length) {
            if(s[i] == ' '){
                i++
                continue
            }
            val start = i
            while(i <s.length && s[i] != ' ')i++
            result.add(Word(s.substring(start,i), start, i - 1))
        }
        return result
    }
}

fun main() {
    val message = "here is muzi here is a secret message"
    val spoiler_ranges = arrayOf(intArrayOf(0,3), intArrayOf(23, 28))
    val result = PGS_468370_retry().solution(message, spoiler_ranges)
    println(result)
}