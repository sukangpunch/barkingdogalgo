package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비밀번호 발음하기
// 구현, 문자열

/**
 * 그냥 빡 구현이다.
 * 1, 2, 3 규칙에 다 만족하면 acceptable, 하나라도 틀리면 not acceptable
 */
public class BOJ_4659 {

    static Character [] vowel = new Character[]{'a','e','i','o','u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            boolean check1 = false;
            boolean check2 = true;
            boolean check3 = true;

            String input = br.readLine();
            if(input.equals("end"))break;

            for(char c: vowel){
                if(input.contains(String.valueOf(c))){
                    check1 = true;
                    break;
                }
            }

            if(!check1){
                sb.append("<").append(input).append(">").append(" is not acceptable.").append("\n");
                continue;
            }

            int vCount = 0;
            int cCount = 0;

            for(int i=0; i<input.length(); i++){
                if(vowelCheck(input.charAt(i))){
                    vCount++;
                    cCount = 0;
                    if(vCount == 3){
                        check2 = false;
                        break;
                    }
                }else{
                    vCount = 0;
                    cCount++;
                    if(cCount == 3){
                        check2 = false;
                        break;
                    }
                }
            }

            if(!check2){
                sb.append("<").append(input).append(">").append(" is not acceptable.").append("\n");
                continue;
            }

            char pre = input.charAt(0);
            for(int i=1; i<input.length(); i++){
                if(pre == input.charAt(i) && (pre != 'e' && pre != 'o')){
                    check3 = false;
                    break;
                }
                pre = input.charAt(i);
            }

            if(!check3){
                sb.append("<").append(input).append(">").append(" is not acceptable.").append("\n");
                continue;
            }

            sb.append("<").append(input).append(">").append(" is acceptable.").append("\n");
        }

        System.out.println(sb);
    }

    static boolean vowelCheck(char c){
        for(char ch : vowel){
            if(c == ch)return true;
        }
        return false;
    }
}
