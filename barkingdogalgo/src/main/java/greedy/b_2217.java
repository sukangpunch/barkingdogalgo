package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> ropes = new ArrayList<>();
        for(int i=0; i<N; i++){
            ropes.add(Integer.parseInt(br.readLine()));
        }

        ropes.sort(Collections.reverseOrder());

        int max = 0;
        for(int i=0; i<ropes.size(); i++){
            int nowRope = ropes.get(i);
            max = Math.max(max, nowRope*(i+1));
        }
        System.out.println(max);

    }
}
