package study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 용돈 관리
public class BOJ_6236 {

    static int N;
    static int M;
    static int []moneys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        moneys = new int[N];

        for(int i=0; i<N; i++){
            int money = Integer.parseInt(br.readLine());
            moneys[i] = money;
        }

        int min = moneys[0];
        for(int i=1; i<N; i++){
            if(min < moneys[i]){
                min = moneys[i];
            }
        }

        int result = calculate(min, 1000000000);
        System.out.println(result);
    }

    private static int calculate(int start, int end) {
        while(start <= end){
            int mid = (start + end)/2;
            int tmp = check(mid);

            if(tmp > M){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }

    private static int check(int mid) {
        int cnt = 1;
        int myMoney = mid;
        for(int i=0; i<N; i++){
            int needMoney = moneys[i];
            if(needMoney > myMoney){
                myMoney = mid;
                cnt++;
            }
            myMoney = myMoney - needMoney;
        }
        return cnt;
    }
}
