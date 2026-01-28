package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 : x(반례만 확인)
// 메모리 : 14100 kb
// 시간 :  104 ms
public class b_1700 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> plugs = new HashSet<>();
        List<Integer> nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }


        for(int i=0; i<K; i++) {
            if(plugs.size() < N){
                plugs.add(nums.get(i));
            }else{
                if(!plugs.contains(nums.get(i))){
                    List<Integer> remainder = nums.subList(i+1, nums.size());
                    int maxIdx = -1;
                    int target = -1;
                    for(int num: plugs){
                        if(!remainder.contains(num)){
                            target = num;
                            break;
                        }
                        if(maxIdx < remainder.indexOf(num)){
                            maxIdx = remainder.indexOf(num);
                            target = num;
                        }
                    }
                    plugs.remove(target);
                    plugs.add(nums.get(i));
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
