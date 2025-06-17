package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 답 보기 : x(반례 확인)
// 메모리 : 14204 kb
// 시간 :  100 ms
public class b_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        nums.sort((a,b)->{
            int groupA = getGroup(a);
            int groupB = getGroup(b);

            if(groupA != groupB){
                return Integer.compare(groupA, groupB); // 더 낮은 우선순위가 먼저 와야 한다.
            }

            if(groupA == 0){
                return Integer.compare(b, a);
            }else if(groupA == 1){
                return Integer.compare(a,b);
            }else{
                return 0;
            }
        });


        int result = 0;
        int pre = 0;
        boolean check = false;

        for(int i=0; i<nums.size(); i++){
            if(!check){
                pre = nums.get(i);
                check = true;
            }else{
                if(pre > 0 && nums.get(i) < 0){
                    result += pre;
                    pre = nums.get(i);
                }else if(pre > 0 && nums.get(i) > 0 || pre <0 && nums.get(i) < 0){
                    if(pre == 1 || nums.get(i)==1){
                        result += pre + nums.get(i);
                    }else{
                        result += pre*nums.get(i);
                    }
                    pre = 0;
                    check = false;
                }else if(pre > 0 && nums.get(i) == 0){
                    result += pre;
                    pre = 0;
                }else if(pre < 0 && nums.get(i) == 0){
                    pre = 0;
                }
            }
        }

        if(check){
            result += pre;
        }

        System.out.println(result);

    }

    private static int getGroup(int num){
        if(num>0)return 0;
        if(num<0) return 1;
        return 2;
    }
}
