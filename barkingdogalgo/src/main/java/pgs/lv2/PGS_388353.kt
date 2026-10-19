package pgs.lv2

class PGS_388353 {
}

class Solution {

    class Node(
        val y : Int,
        val x: Int,
        val c: Char
    ){}

    companion object {
        val dx = intArrayOf(0, 0, 1, -1)
        val dy = intArrayOf(1, -1, 0, 0)
    }

    fun solution(storage: Array<String>, requests: Array<String>): Int {
        val n = storage.size
        val m = storage[0].length

        val grid = Array(n+2) { CharArray(m+2) }
        for (i in 0 until n+2){
            for (j in 0 until m+2){
                grid[i][j] = if(i in 1..n && j in 1..m) storage[i-1][j-1] else '.'
            }
        }

        for (req in requests) {
            val target = req[0]
            when (req.length){
                2 -> crane(grid, target)
                else -> forklift(grid, target)
            }
        }

        return grid.sumOf{ row -> row.count { it != '.'} }
    }

    private fun crane(grid: Array<CharArray>, target: Char) {
        for(i in grid.indices){
            for (j in grid[0].indices){
                if(grid[i][j] == target){
                    grid[i][j] = '.'
                }
            }
        }
    }

    private fun forklift(grid: Array<CharArray>, target: Char) {
        val queue = ArrayDeque<Node>()
        queue.add(Node(0,0,'.'))
        val n = grid.size
        val m = grid[0].size
        var visited = Array(n) { BooleanArray(m) }

        while(queue.isNotEmpty()){
            val node = queue.removeFirst()

            for(i in 0..3){
                val ny = node.y + dy[i]
                val nx = node.x + dx[i]

                if(ny in 0..<n && nx in 0..<m && !visited[ny][nx]){
                    if(grid[ny][nx] == target){
                        grid[ny][nx] = '.'
                    }else if(grid[ny][nx] == '.'){
                        queue.add(Node(ny, nx,'.'))
                    }else{
                        continue
                    }
                    visited[ny][nx] = true
                }
            }
        }
    }
}

fun main() {
    val storage = arrayOf("HAH", "HBH", "HHH", "HAH", "HBH")
    val requests = arrayOf("C", "B", "B", "B", "B", "H")
    println(Solution().solution(storage, requests)) // 기대값: 4
}