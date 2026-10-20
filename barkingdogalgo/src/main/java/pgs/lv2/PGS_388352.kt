package pgs.lv2

class PGS_388352 {

    class Solution {

        companion object {
            const val LEN = 5
        }

        private var count = 0

        fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
            count = 0
            backtrack(
                n = n,
                q = q,
                ans = ans,
                start = 1,
                selected = IntArray(LEN),
                depth = 0
            )

            return count
        }

        private fun backtrack(
            n: Int,
            q: Array<IntArray>,
            ans: IntArray,
            start : Int,
            selected : IntArray,
            depth: Int
        ) {
            if(depth == LEN){
                if(isValid(q, ans, selected)){
                    count++
                }
                return
            }

            val last = n - (LEN - depth) + 1
            for (number in start..last){
                selected[depth] = number

                if(isPossible(q, ans, selected, depth + 1)){
                    backtrack(
                        n = n,
                        q = q,
                        ans = ans,
                        start = number + 1,
                        selected = selected,
                        depth = depth + 1
                    )
                }
            }
        }

        private fun isValid(q: Array<IntArray>, ans: IntArray, selected: IntArray): Boolean {
            for(row in q.indices){
                var matched = 0

                for(number in selected){
                    if(number in q[row]) {
                        matched++
                    }
                }

                if(matched != ans[row]){
                    return false
                }
            }

            return true
        }

        private fun isPossible(q: Array<IntArray>, ans: IntArray, selected: IntArray, size: Int): Boolean {
            for (row in q.indices){
                var matched = 0

                for(i in 0 until size){
                    if(selected[i] in q[row]){
                        matched++
                    }
                }

                val remaining = LEN - size

                if(matched > ans[row]){
                    return false
                }

                if(matched + remaining < ans[row]){
                    return false
                }
            }
            return true
        }
    }
}
