package it_company_work_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 삼각형과 세 변
// 수학, 구현, 기하학

/**
 * 조건문 처리 순서가 중요했던 문제
 * 두 변의 길이가 같은 삼각형에서 만약, 1 1 5 삼각형이라면, Invalid이지만,
 * 두 변길이의 같음을 먼저 처리한다면 Isosceles 를 리턴하게 되므로 조건문 순서를 제대로 잡아야 한다.
 */
public class BOJ_5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = br.readLine();
            if(s.equals("0 0 0"))break;

            int [] lines = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(lines);
            if(lines[0] == lines[1] && lines[1] == lines[2]){
                sb.append("Equilateral").append("\n");
            }else if(lines[0] + lines[1] <= lines[2]){
                sb.append("Invalid").append("\n");
            }else if(lines[0]==lines[1] || lines[1] == lines[2] || lines[0] == lines[2]){
                sb.append("Isosceles").append("\n");
            }else{
                sb.append("Scalene").append("\n");
            }
        }

        System.out.println(sb);
    }
}
