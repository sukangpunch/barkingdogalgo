package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 :
// 메모리 :  kb
// 시간 :   ms
public class b_18870 {
    static List<Integer> sequence;
    static int [] idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        idx = new int[N];
        sequence = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            idx[i] = num;
            set.add(num);
        }

        sequence = new ArrayList<>(set);
        Collections.sort(sequence);

        for(int i=0; i<N; i++){
            sb.append(binarySearch(0,sequence.size()-1, idx[i])).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int start, int end, int num){
        int mid = (start + end)/2;

        if(num < sequence.get(mid)){
            return binarySearch(start, mid-1, num);
        }else if(num > sequence.get(mid)){
            return binarySearch(mid+1, end, num);
        }else{
            return mid;
        }
    }
}
