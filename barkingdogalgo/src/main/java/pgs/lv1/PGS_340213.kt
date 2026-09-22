package pgs.lv1

// [PCCE] 동영상 재생기
/**
 * 문자열 시간 규격을 비교, 연산에 유리하게 정수로 바꾸고, 해당 정수를 다시 문자열 시간으로 변경하는 문제.
 * coerceIn 확장 함수를 통해 범위를 벗어나는 값을, min, max 값으로 치환할 수 있도록 한다.
 */

class PGS_340213 {

    companion object {
        const val SIZE : Int = 10
    }

    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer = ""

        val videoLen = transferStringTimeToIntTime(video_len);
        var now = transferStringTimeToIntTime(pos);
        val opStart = transferStringTimeToIntTime(op_start);
        val opEnd = transferStringTimeToIntTime(op_end);

        if(now in opStart..opEnd) {
            now = opEnd
        }

        for(command in commands){
            now = if(command == "next") now + SIZE else now - SIZE
            now = now.coerceIn(0, videoLen) // min 보다 작으면 min 반환, max 보다 크면 max반환

            if(now in opStart..opEnd) {
                now = opEnd
            }
        }

        answer = transferIntTimeToStringTime(now)
        return answer
    }

    private fun transferStringTimeToIntTime(videoLen: String): Int {
        val times = videoLen.split(":")
        val minute = times[0].toInt()
        val second = times[1].toInt()

        return minute * 60 + second
    }

    private fun transferIntTimeToStringTime(time: Int): String {
        val minute = time / 60
        val second = time % 60
        val result = "${minute.toString().padStart(2, '0')}:${second.toString().padStart(2, '0')}"

        return result
    }
}

fun main(){
    val solution = PGS_340213()
    println(solution.solution("34:33", "13:00", "00:55", "02:55", arrayOf("next", "prev")) + " (expect 13:00)")
    println(solution.solution("10:55", "00:05", "00:15", "06:55", arrayOf("prev", "next", "next")) + " (expect 06:55)")
    println(solution.solution("07:22", "06:55", "00:00", "00:00", arrayOf("next")) + " (expect 07:05)")
    println(solution.solution("01:00", "00:08", "00:00", "00:05", arrayOf("prev")) + " (expect 00:05)")
}
