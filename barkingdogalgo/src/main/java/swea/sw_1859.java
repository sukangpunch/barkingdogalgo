package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백만 장자 프로젝트 - D2
public class sw_1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int [] days = new int[N];
            String [] daysStr = br.readLine().split(" ");

            for(int i=0;i<N;i++) {
                days[i] = Integer.parseInt(daysStr[i]);
            }

            long result = find(N, days);
            sb.append("#").append(t+1).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static long find(int n, int[] days) {
        long max = 0;
        long result = 0;
        for(int i=n-1; i>=0; i--) {
            if(max == 0) {
                max = days[i];
                continue;
            }

            if(max > days[i]) {
                long cal = max - days[i];
                result += cal;
                continue;
            }

            if(max < days[i]) {
                max = days[i];
            }
        }
        return result;
    }

}
