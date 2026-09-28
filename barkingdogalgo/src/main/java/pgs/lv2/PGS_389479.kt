package pgs.lv2

class PGS_389479 {

    fun solution(players: IntArray, m: Int, k: Int): Int {
        val size = players.size
        var servers = IntArray(size)
        var count = 0;

        for(i in 0 until size){
            val need = players[i] / m

            var running = 0
            for(j in maxOf(0, i-k+1) until i) {
                running += servers[j]
            }

            if (need > running){
                servers[i] = need - running
                count += servers[i]
            }
        }

        return count;
    }

}