package barkingdog_youtube.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


// 카드
public class b_11652_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1); // num 이 신규 값이라면, default 0 을 가져오고, 아니라면 value 를 가져와서 처리
        }

        int maxCnt = -1;
        long maxKey = 0;
//        O(N) 순회 + O(N) 해시 탐색 = 실질적으로 2배 오버헤드
//        for(long key : map.keySet()){
//            int value = map.get(key); // 매번 해시 테이블을 탐색
//            if(value > maxCnt){
//                maxCnt = value;
//                maxKey = key;
//                continue;
//            }
//
//            if(value == maxCnt){
//                maxKey = Math.min(maxKey, key);
//            }
//        }

        // entry 로 가져오는게 더 빠르다. 추가 해시 탐색이 없기 떄문
        for(Map.Entry<Long, Integer> entry :map.entrySet()){
            int value = entry.getValue();
            long key = entry.getKey();
            if(value > maxCnt){
                maxCnt = value;
                maxKey = key;
                continue;
            }

            if(value == maxCnt){
                maxKey = Math.min(maxKey, key);
            }
        }

        System.out.println(maxKey);
    }

}
