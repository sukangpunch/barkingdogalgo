package array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1475 {
    static int[] nums = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for(int i=0; i<input.length(); i++){
            int num = input.charAt(i) - '0';
            nums[num]++;
        }

        int cnt = 0;
        int sixAndNine = 0;

        for(int i=0; i<nums.length; i++){
            if(i == 6 || i == 9){
                sixAndNine += nums[i];
                continue;
            }

            if(nums[i] > cnt){
                    cnt = nums[i];
            }
        }
        sixAndNine = sixAndNine % 2 == 0 ? sixAndNine / 2 : sixAndNine / 2 + 1;
        System.out.println(Math.max(cnt, sixAndNine));
    }
}
