package pgs.lv1

// 노란불 신호등
/**
 * ai 활용
 * 신호등의 최대 주기를 구하기 위해 최소공배수 구함. 해당 주기를 구하지 않으면 -1 을 리턴하지 못하고 무한으로 돌게 된다.
 * 최대 주기를 구했으면 반복 시작
 * 시간이 1부터 최대 주기까지 돌며, 현재 시간 마다 각 신호등이 노란불인지 확인. 가지치기를 위해 노란불이 아니라면 더 탐색하지말고 바로 break
 * 만약 모든 신호등이 노란색이라면 거기서 멈추고 현재 시간 리턴
 */
class PGS_468371_retry {

    class Signal(
        var green: Long,
        var yellow: Long,
        var red: Long,
        var size: Long,
    ){

        fun now(time: Long): Boolean {
            var remain = time % size

            if(remain <= green){
                return false
            }else if(remain <= yellow + green){
                return true
            }else{
                return false
            }
        }
    }

    fun solution(signals: Array<IntArray>): Int {
        var n : Long = 1;
        var ran : Long = 0;
        val inputs = mutableListOf<Signal>()
        for (signal in signals) {
            val green = signal[0].toLong()
            val yellow = signal[1].toLong()
            val red = signal[2].toLong()

            val size = green + yellow + red
            ran = lcm(n, size)
            n = ran

            inputs.add(Signal(green, yellow, red, size))
        }

        var time = 1L;
        var check = false

        while(time <= ran){
            var isYellow = true
            for(signal in inputs){
                if(!signal.now(time)){
                    isYellow = false
                    break
                }
            }
            if(isYellow){
                check = true
                break
            }

            time++;
        }

        if(check){
            return time.toInt()
        }else{
            return -1
        }
    }

    private fun gdc(n: Long, size: Long): Long {
        var a = n
        var b = size

        while(b != 0L){
            val temp = b
            b = a % b
            a = temp
        }
        return a
    }

    private fun lcm(a: Long, b: Long): Long {
        return a / gdc(a,b) * b
    }
}

fun main() {
    val signals = arrayOf(intArrayOf(2, 1, 2), intArrayOf(5, 1, 1))
    println(PGS_468371_retry().solution(signals))
}