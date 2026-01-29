package barkingdog_youtube.data_structure.binary_search_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// 보석 도둑
public class b_1202_learn {

    static class Jewel implements Comparable<Jewel>{

        int v;
        int m;

        public Jewel(int v, int m) {
            this.v = v;
            this.m = m;
        }

        @Override
        public int compareTo(Jewel o) { // i 인덱스의 보석이 가방에 들어가지 않으면 이후 i+1, i+N 의 보석들은 당연히 안들어가기 때문에 무게순으로 정렬
            if(this.m == o.m){
                return o.v - this.v;
            }
            return this.m - o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int [] bags = new int[k];
        List<Jewel> jewels = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            jewels.add(new Jewel(v,m));
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        Collections.sort(jewels);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long count = 0;
        int jIdx = 0;
        for(int i=0; i<k; i++){
            while (jIdx < N && jewels.get(jIdx).m <= bags[i]){
                pq.offer(jewels.get(jIdx).v);
                jIdx++;
            }

            if(!pq.isEmpty()){
                count += pq.poll();
            }
        }

        System.out.println(count);
    }
}
