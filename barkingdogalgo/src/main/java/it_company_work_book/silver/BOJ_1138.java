package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 한 줄로 서기
// 구현, 그리디
/**
 * 답지 확인함.
 * 1~N 의 키를 가진 사람들이 줄을 설 때, input의 값은, 각 자리의 왼쪽에 빈칸을 뜻한다.
 * 즉 2 1 1 0 이라면, 1의 위치는 배열의 왼쪽이 2칸 비어있는 상태의 위치, 2의 위치는 배열의 왼쪽이 1칸 비어있는 상태
 * 3의 위치도 배열의 왼쪽에 1칸 비어있는 상태, 4는 0칸 비어있는 상태이다(마지막에 끼워넣기)
 * 키가 작은 순서대로 기입하기 때문에, 이것이 가능해지는것.
 * 그래서 그리디 문제인듯 하다.
 */
public class BOJ_1138 {

    static final int BLANK = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] line = new int[N];
        Arrays.fill(line, BLANK);

        String []s = br.readLine().split(" ");
        for(int tall=0; tall<N; tall++){
            int leftCount = Integer.parseInt(s[tall]);

            int count = 0;
            for(int i=0; i<N; i++){
                if(line[i] == BLANK){
                    if(count == leftCount){
                        line[i] = tall + 1;
                        break;
                    }
                    count++;
                }
            }
        }

        for(int i=0; i<N; i++){
            sb.append(line[i]).append(" ");
        }

        System.out.println(sb);
    }
}
