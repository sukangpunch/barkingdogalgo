package barkingdog_youtube.data_structure.binary_search_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// 이중 우선순위 큐
// 우선순위 큐(최대, 최소) 2개 사용 시 시간초과 발생
// 최대키, 최소키 둘다 접근 가능한 TreeMap 으로 해결
public class b_7662_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                String[] s = br.readLine().split(" ");
                if (s[0].equals("I")) {
                    int num = Integer.parseInt(s[1]);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    int num = Integer.parseInt(s[1]);

                    if (map.isEmpty()) {
                        continue;
                    }

                    if (num == 1) {
                        int max = map.lastKey();
                        if (map.get(max) > 1) {
                            map.put(max, map.get(max) - 1);
                        } else {
                            map.remove(max);
                        }
                    } else if (num == -1) {
                        int min = map.firstKey();
                        if (map.get(min) > 1) {
                            map.put(min, map.get(min) - 1);
                        }else{
                            map.remove(min);
                        }
                    }else{
                        map.remove(num);
                    }
                }
            }

            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                int max = map.lastKey();
                int min = map.firstKey();
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }
}
