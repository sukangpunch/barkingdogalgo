package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 등수 구하기
// 구현

/**
 * GPT 의 도움을 받았다...
 * 너무 복잡하게 생각했나보다. ranks 배열을 두어 N만큼의 배열의 랭킹을 다 정해 놓은 다음 pre에 이전값을 저장하여 어쩌구 저쩌구...
 * 로 풀려고 하니까 21퍼센트에서 계속 터진다.
 * 간단하게, N이 0일때 -> 무조건 1, N이 P와 같은데 가장 마지막 요소가 point 보다 같거나 클 때 -> -1
 * 위 두가지 경우 말고는 정상적인 랭킹 매김이 가능하다.
 * 그냥 if(arr[i] > point) 인 경우에만 rank 증가시키고, 같거나 다르면 반복을 탈출하고 출력하면 되는 것.
 * 동일한 점수 부분은 어짜피 같은 등수로 처리 되고, 동일한 점수여서 들어갈 자리가 없는 경우는 N==P 조건에서 처리를 해주기 때문에 고려 X
 * 반복문 안에서 모든 예외를 처리하려고 하다 보니까, 더 복잡하게 흘러간것 같다.
 * 다음에는 뻔한 예외 부분을 먼저 찾고, 반복 처리 하기 전에 해당 예외 케이스를 먼저 제외할 순 없는지를 생각 해 보아야 겠다.
 */
public class BOJ_1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int point = Integer.parseInt(s[1]);
        int P = Integer.parseInt(s[2]);
        int[] arr = new int[P];

        if (N == 0) {
            System.out.println(1);
            return;
        }

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int rank = 1;
        if(N == P && point <= arr[N-1]){
            System.out.println(-1);
            return;
        }

        for(int i=0; i<N; i++){
            if(arr[i] > point){
                rank++;
            }else{
                break;
            }
        }
        System.out.println(rank);
    }
}
