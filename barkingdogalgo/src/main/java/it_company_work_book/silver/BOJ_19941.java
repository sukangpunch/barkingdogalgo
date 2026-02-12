package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 햄버거 분배
// 그리디
/**
 * 쉬운 내용이었다.
 * P가 등장하면 i-k , i+k 범위 내에 햄버거를 찾으면(낮은 인덱스부터) 바로 체크하고 break
 */
public class BOJ_19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        boolean [] visited = new boolean[N];
        String input = br.readLine();

        for(int i=0; i<N; i++){
            if(input.charAt(i) == 'P'){
                visited[i] = true;
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            if(input.charAt(i) == 'P'){
                for(int j=i-K; j<=i+K; j++){
                    if(j>= 0 && j<N){
                        if(input.charAt(j) == 'H' && !visited[j]){
                            cnt++;
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
