package study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A와 B 2
// 브루트포스, 재귀, 가지치기

/**
 * 처음에 재귀로 브루트포스로 구현했는데 시간초과 발생. 가지치기가 가능한 문제였다.
 * S->T 방향이 아닌 T->S 의 방향으로 나아갔다. 역방향으로 탐색 할 때 가지치기는 다음과 같다.
 * 현재 탐색중인 문자열의 맨 뒤가 'A' 인가? -> 아니면 이 문자열은  A를 추가해서 만들어진 문자열이 아니다(경로 차단)
 * 맨 앞이 'B' 인가? -> 아니면 이 문자열은 B를 추가하고 뒤집어져서 만들어진 문자열이 아니다.
 * S->T 였으면 그냥 길이에 맞춰서 ABABA, BABABA 두갈래로 계속 탐색을 하겠지만,
 * T->S 방향에서는 T가 만들어 질 수 있는 가능성을 체크 할 수 있기 때문에 가지치기가 가능해진다.
 */
public class BOJ_12919 {

    static String S;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();

        checkChange(T);

        System.out.println(result);
    }

    private static void checkChange(String t) {
        if(S.length() == t.length()){
            if(S.equals(t)){
                result = 1;
            }
            return;
        }

        if(t.charAt(t.length() - 1) == 'A'){
            checkChange(t.substring(0, t.length() - 1));
        }

        if(t.charAt(0) == 'B'){
            String reversed = new StringBuilder(t.substring(1)).reverse().toString();
            checkChange(reversed);
        }
    }
}
