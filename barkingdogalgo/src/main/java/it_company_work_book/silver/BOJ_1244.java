package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스위치 켜고 끄기
// 구현, 시뮬레이션
/**
 * 나름 쉬운 구현 문제
 * boolean 배열로 스위치 키고 끄고를 구현
 * 문제를 잘 읽어야 하는데, 20개씩 스위치를 출력하고, 개행을 해야한다.
 */
public class BOJ_1244 {

    static boolean []switches;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        switches = new boolean[N+1];
        String []s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            switches[i+1] = Integer.parseInt(s[i]) == 1;
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int gender = Integer.parseInt(s[0]);
            int num = Integer.parseInt(s[1]);
            simulate(gender, num);
        }

        for(int i = 1; i<=N; i++){
            sb.append(switches[i] ? 1:0).append(" ");
            if(i%20 == 0){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void simulate(int gender, int num) {
        if(gender == 1){
            for(int i=num; i<=N; i +=num){
                switches[i] = !switches[i];
            }
        }else{
            switches[num] = !switches[num];
            int back = num-1;
            int front = num+1;
            while(true){
                if(back <= 0 || front > N)break;
                if(switches[back] == switches[front]){
                    switches[back] = !switches[back];
                    switches[front] = !switches[front];
                    back -= 1;
                    front += 1;
                }else{
                    break;
                }
            }
        }
    }
}
