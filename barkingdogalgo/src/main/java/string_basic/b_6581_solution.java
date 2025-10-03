package string_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_6581_solution {
    int idx = 0;
    StringBuilder sb = new StringBuilder();

    private void br() {
        sb.append("\n");
        idx = 0;
    }

    private void hr(){
        if(idx != 0) br();
        sb.append("-".repeat(80));
        br();
    }

    private void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        ArrayList<String> arr = new ArrayList<>();
        while((s = br.readLine()) != null){  // ctrl + D(EOF) 를 해줘야 종료됌
            StringTokenizer st = new StringTokenizer(s, " \t\n"); // 문자열 S를 공백, 탭, 줄바꿈 문자로 기준으로 토큰으로 쪼갠다.
            while(st.hasMoreTokens()){
                arr.add(st.nextToken());
            }
        }
        for(String str : arr){
            if(str.equals("<br>")){
                br();
                continue;
            }

            if(str.equals("<hr>")){
                hr();
                continue;
            }

            if(idx + str.length() + (idx == 0?0:1) > 80){ // IDX가 0인건 새로운 줄에서 처음 시작 문자 추가 이므로 공백을 신경 X
                idx = 0;                                  // IDX 가 0이 아니라면 단어 뒤에 단어를 붙이는 것이므로 공백이 추가되어야 하기 때문에 1 추가
                br();
            }

            if(idx !=0) sb.append(' '); // IDX가 0이 아니고 단어가 추가되는거면, 단어 뒤에 단어를 추가하는 것이므로 공백 추가
            sb.append(str);
            idx += str.length() + (idx == 0?0:1);
        }

        br();
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new b_6581_solution().solution();
    }
}
