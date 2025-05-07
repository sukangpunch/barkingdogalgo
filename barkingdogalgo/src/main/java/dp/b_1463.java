package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 18848 kb
// 시간 : 152ms
public class b_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N+1];

        for(int i = N; i>1; i--){
            if(arr[i-1] == 0){
                arr[i-1] = arr[i]+1;
            }else{
                arr[i-1] = Math.min(arr[i-1], arr[i]+1);
            }

            if(i%3 == 0){
                if(arr[i/3] == 0){
                    arr[i/3] = arr[i]+1;
                }else{
                    arr[i/3] = Math.min(arr[i/3], arr[i]+1);
                }
            }

            if(i%2 == 0){
                if(arr[i/2] == 0){
                    arr[i/2] = arr[i]+1;
                }else{
                    arr[i/2] = Math.min(arr[i/2], arr[i]+1);
                }
            }
        }

        System.out.println(arr[1]);
    }
}
