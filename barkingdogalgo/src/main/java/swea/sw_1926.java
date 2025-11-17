package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 간단한 369 게임
public class sw_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            if(i < 10)
            {
                if(i == 3 || i == 6 || i == 9){
                    sb.append("-").append(" ");
                    continue;
                }
                sb.append(i).append(" ");
            }
            else if(i < 1000){
                int now = i;
                StringBuilder result = new StringBuilder();
                StringBuilder numResult = new StringBuilder();

                while(now > 0){
                    int tens = now % 10;
                    if(tens == 3 || tens == 6 || tens == 9){
                        result.append("-");
                    }else{
                        numResult.insert(0, tens);
                    }
                    now /= 10;
                }

                if(result.length() != 0){
                    sb.append(result).append(" ");
                }else{
                    sb.append(numResult).append(" ");
                }
            }
            else{
                sb.append(i);
            }

        }
        System.out.println(sb);
    }
}
