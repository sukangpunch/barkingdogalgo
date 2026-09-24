package pgs.lv1

class PGS_258712 {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var maxPresent: Int = 0
        val giftMap = mutableMapOf<String, MutableMap<String, Int>>()

        for(giver in friends) {
            giftMap[giver] = mutableMapOf()
            for(receiver in friends){
                giftMap.getOrPut(giver){ mutableMapOf() }[receiver] = 0
            }
        }

        for(gift in gifts){
            val (giver, receiver) = gift.split(" ")
            giftMap[giver]!![receiver] = giftMap[giver]!![receiver]!!+1
        }


        for(friend in giftMap.keys){
            var giftToGive: Int = 0;
            val friendToGiveMap = giftMap[friend]!!

            for(target in friendToGiveMap.keys){
                if(friend.equals(target))continue
                val giveCount = friendToGiveMap[target]!!
                val receiverCount = giftMap[target]!![friend]!!

                if (giveCount > receiverCount){
                    giftToGive += 1
                }else if (giveCount == receiverCount){
                    val allMyGiveCount = countAll(friend, giftMap)
                    val allTargetGiveCount = countAll(target, giftMap)

                    if(allMyGiveCount > allTargetGiveCount){
                        giftToGive += 1
                    }
                }
            }

            maxPresent = Math.max(maxPresent, giftToGive)
        }

        return maxPresent
    }

    private fun countAll(friend : String, giftMap: MutableMap<String, MutableMap<String, Int>>): Int {
        val giveCount = giftMap.getValue(friend).values.sum()
        val receiveCount = giftMap.values.sumOf{ giverMap ->
            giverMap.getValue(friend)
        }
        return giveCount - receiveCount

    //        var giveCount = 0;
//        var receiveCount = 0;
//
//        val giftMyMap = giftMap[friend]!!
//
//        for(target in giftMyMap.keys){
//            giveCount += giftMyMap[target]!!
//        }
//
//        for(giverMap in giftMap.values){
//            receiveCount += giverMap[friend]!!
//        }
//
//        return giveCount - receiveCount
    }
}

fun main() {
    val friends = arrayOf("a", "b", "c")
    val gifts = arrayOf(
        "a b",
        "b a",
        "c a",
        "a c",
        "a c",
        "c a"
    )

    val result = PGS_258712().solution(friends, gifts)
    println(result) // 예상 결과: 0
}
