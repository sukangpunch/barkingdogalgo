package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class b_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String makeNum = "";
        List<BigInteger> nums = new ArrayList<>();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<input.length(); j++){
                if(makeNum.equals("") && !Character.isDigit(input.charAt(j))){
                    continue;
                }

                if(!makeNum.equals("") && !Character.isDigit(input.charAt(j))){
                    nums.add(new BigInteger(makeNum));
                    makeNum = "";
                }else{
                    if(!makeNum.equals("") && makeNum.charAt(0) == '0'){
                        makeNum = makeNum.substring(1, makeNum.length());
                    }
                    makeNum += input.charAt(j);
                }
            }
            if(!makeNum.equals("")){
                nums.add(new BigInteger(makeNum));
                makeNum = "";
            }
        }

        Collections.sort(nums);
        for(BigInteger num: nums){
            System.out.println(num);
        }
    }
}
