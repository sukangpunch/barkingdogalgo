package study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 가장 긴 증가하는 부분 수열4
public class BOJ_14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        String []s = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int [] dp = new int[N];
        int [] pre = new int[N];
        Arrays.fill(dp, 1);
        pre[0] = 0;

        for(int i=1; i<N; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }else{
                    if(dp[i] <= 1) {
                        dp[i] = 1;
                        pre[i] = i;
                    }
                }
            }
        }

        int max = 0;
        int maxIdx = 0;
        for(int i=0; i<N; i++){
            if(max < dp[i]){
                max = dp[i];
                maxIdx = i;
            }
        }

        // 최대 부분수열 길이
        sb.append(max).append("\n");

        Stack<Integer> st = new Stack<>();
        st.push(arr[maxIdx]);
        int tmp = maxIdx;

        while(true){
            if(tmp == pre[tmp])break;
            tmp = pre[tmp];
            st.push(arr[tmp]);
        }

        while(!st.isEmpty()){
            sb.append(st.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
