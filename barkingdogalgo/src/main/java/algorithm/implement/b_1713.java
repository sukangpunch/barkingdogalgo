package algorithm.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 후보 추천하기
public class b_1713 {

    static class CandidateInfo{
        int count;
        int order;

        public CandidateInfo(int count, int order){
            this.count = count;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int recommended = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");

        Map<Integer,CandidateInfo> map = new HashMap<>();

        int orderId = 0;
        for(int i=0; i < recommended; i++){
            int now = Integer.parseInt(s[i]);

            if(map.containsKey(now)){
                 map.get(now).count++;
            }else{
                if(map.size() < N){
                    map.put(now, new CandidateInfo(1, orderId++));
                }else{
                    int minAndOldKey = findMinAndOldKey(map);
                    map.remove(minAndOldKey);
                    map.put(now, new CandidateInfo(1, orderId++));
                }
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static int findMinAndOldKey(Map<Integer, CandidateInfo> map) {
        int minKey = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        int minOrder = Integer.MAX_VALUE;

        for(Map.Entry<Integer, CandidateInfo> entry : map.entrySet()){
            if(entry.getValue().count < minValue){
                minValue = entry.getValue().count;
                minOrder = entry.getValue().order;
                minKey = entry.getKey();
            }else if(entry.getValue().count == minValue){
                if(entry.getValue().order < minOrder){
                    minValue = entry.getValue().count;
                    minOrder = entry.getValue().order;
                    minKey = entry.getKey();
                }
            }
        }
        return minKey;
    }
}
