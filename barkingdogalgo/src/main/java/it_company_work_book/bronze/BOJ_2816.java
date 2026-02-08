package it_company_work_book.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 디지털 티비
// 구현, 해 구성하기

/**
 * 그냥 간단한 구현 문제이다.(더 좋은 방법이 있다는 것을 알지만..)
 * 만약 최적 해를 구하는 문제였다면 매우 어려웠을 듯 하다.
 * kbs1이 제일 위, kbs2 는 kbs2 아래로 옮기기만 하면 된다.
 * kbs1을 찾을 때까지 내려가고, 제일 위로 올린다. (kbs1찾았다는 플래그를 셋팅)
 * kb1을 찾았으면, kb2를 똑같이 찾고, 제일 위에서 바로 아래칸으로 옮긴다. (kbs2찾았다는 플래그 셋팅)
 * kb2를 찾았으면 반복문을 탈출한다.
 */
public class BOJ_2816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String [] channel = new String[N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            channel[i] = s;
        }

        int cursor = 0;
        boolean checkKbs1Channel = false;
        boolean checkKbs2Channel = false;
        while(true){
            if(!checkKbs1Channel){
                if(channel[cursor].equals("KBS1")){
                    checkKbs1Channel = true;
                    while(cursor != 0){
                        String tmp = channel[cursor];
                        channel[cursor] = channel[cursor-1];
                        channel[cursor-1] = tmp;
                        cursor--;
                        sb.append("4");
                    }
                }else{
                    cursor++;
                    sb.append("1");
                }
            }else{
                if(channel[cursor].equals("KBS2")){
                    while(cursor != 1){
                        String tmp = channel[cursor];
                        channel[cursor] = channel[cursor-1];
                        channel[cursor-1] = tmp;
                        cursor--;
                        sb.append("4");
                    }
                    checkKbs2Channel = true;
                }else{
                    cursor++;
                    sb.append("1");
                }
            }

            if(checkKbs2Channel){
                break;
            }
        }

        System.out.println(sb);
    }
}
