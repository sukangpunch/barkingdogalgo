package stack_que_deq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_1021 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }

        String []input = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(input[i]);

            int idx = list.indexOf(target);
            int mid = list.size()/2;

            if(list.get(0) == target){
                list.remove(0);
                continue;
            }

            if(idx <= mid){
                for(int j=0; j<idx; j++){
                    list.add(list.size()-1, list.remove(0));
                    cnt++;
                }
            }else{
                for(int j=0; j< list.size()-idx; j++){
                    list.add(0,list.remove(list.size()-1));
                    cnt++;
                }
            }
            list.remove(0);
        }
        System.out.println(cnt);
    }
}
