package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기 5
public class b_15688_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] counting = new int[2000001];

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            counting[num+1000000]++;
        }

        for(int i=0; i<=2000000; i++){
            while(counting[i] > 0){
                sb.append(i - 1000000).append("\n");
                counting[i]--;
            }
        }

        System.out.println(sb);
    }
}
