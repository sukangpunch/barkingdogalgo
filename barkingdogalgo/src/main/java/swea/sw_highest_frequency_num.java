package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최빈수 구하기
public class sw_highest_frequency_num {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int num = Integer.parseInt(br.readLine());
            String []str = br.readLine().split(" ");
            int [] scores = new int[101];

            for(int i=0;i<str.length;i++) {
                int now = Integer.parseInt(str[i]);
                scores[now] += 1;
            }

            int max = scores[0];
            int maxIdx = 0;
            for(int i=1; i<=100; i++){
                if(scores[i] >= max) {
                    maxIdx = i;
                    max = scores[i];
                }
            }

            sb.append("#").append(t).append(" ");
            sb.append(maxIdx).append("\n");
        }
        System.out.println(sb);
    }
}
