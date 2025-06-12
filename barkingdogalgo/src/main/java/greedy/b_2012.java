package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 답 보기 : x
// 메모리 :  kb
// 시간 :   ms
public class b_2012 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] ranks = new int[N];

        for(int i = 0; i < N; i++){
            int rank = Integer.parseInt(br.readLine());
            ranks[i] = rank;
        }

        Arrays.sort(ranks);
        for(int i = 0; i < N; i++){
            count += Math.abs((i+1) - ranks[i]);
        }

        System.out.println(count);
    }
}
