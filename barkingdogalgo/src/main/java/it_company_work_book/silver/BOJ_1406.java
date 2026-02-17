package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 에디터
// 스택
/**
 * 간단한 스택 활용문제,
 * 커서 왼쪽 위치는 left 스택, 커서 오른쪽 위치는 right
 * 마지막 출력때는 right 에 몰아넣고 출력
 */
public class BOJ_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            left.add(input.charAt(i));
        }

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("P")) {
                left.push(s[1].charAt(0));
            } else if (s[0].equals("L")) {
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            } else if (s[0].equals("D")) {
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            } else if (s[0].equals("B")) {
                if(!left.isEmpty()){
                    left.pop();
                }
            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }

        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
