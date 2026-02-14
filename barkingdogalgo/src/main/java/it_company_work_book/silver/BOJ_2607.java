package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비슷한 단어
// 구현, 문자열
/**
 * 문자를 index 에 맞게 count를 증가시킨다.
 * 만약 비교 문자 길이가 다르면 추가, 혹은 삭제 연산만 가능
 * 만약 비교 문자 길이가 같다면 변경만 가능
 * 이를 고려해서 처리하면 된다.
 */
public class BOJ_2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for(int i=0; i<N; i++){
            String word = br.readLine();
            words[i] = word;
        }

        String target = words[0];
        int [] count = new int[26];
        for(int i=0; i<target.length(); i++){
            int idx = target.charAt(i) - 'A';
            count[idx]++;
        }

        int result = 0;
        for(int i=1; i<N; i++){
            int [] tmp = new int[26];
            for(int j=0; j<words[i].length(); j++){
                int idx = words[i].charAt(j) - 'A';
                tmp[idx]++;
            }
            // 1. 한쪽이 더 길때는 무조건 추가하는 체크로 비교
            // 2. 길이가 같을 때는 무조건 한 단어를 변경하는 체크로 비교

            if(target.length() != words[i].length()){
                if(checkDiffLength(count, tmp)){
                    result++;
                    continue;
                }
            }else{
                if(checkSameLength(count, tmp)){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean checkSameLength(int[] count, int[] tmp) {
        int difference = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] >= tmp[i]){
                difference += count[i] - tmp[i];
            }else{
                difference += tmp[i] - count[i];
            }
        }

        if(difference/2 <= 1){
            return true;
        }else{
            return false;
        }
    }

    private static boolean checkDiffLength(int[] count, int[] tmp) {
        int difference = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] >= tmp[i]){
                difference += count[i] - tmp[i];
            }else{
                difference += tmp[i] - count[i];
            }
        }

        if(difference <= 1){
            return true;
        }else{
            return false;
        }
    }



}
