package study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 두 배열의 합
// 부분합, 투포인터

/**
 * 시간복잡도 : O(N^2)
 * 요소에 음수가 있을 줄 몰라서 잘못 접근을 했다.
 * 해결의 키 포인트는, 각 배열에사 나올 수 있는 부분배열 값들을 구한 뒤 오름차순 정렬(중복값은 Map으로 카운팅) 하는 것
 * 정렬된 중복없는 A배열을 0부터, B배열을 B.size()-1 부터 탐색하여 두 합이 T가 되는지를 확인한다.
 * 이 때, 각 배열의 Map 에서 해당 요소의 개수만큼 조합이 나오므로 aCount * bCount 결과를  result에 더한다.
 * 오름 차순 정렬이므로, A배열의 큰값, B배열의 작은 값을 비교해야하므로 둘다 left++, right++ 로 넘어간다.
 * 만약 T보다 크다면 right를 줄여서 작은 수로 더하고, T보다 작다면 left 를 증가시켜 더 큰 수를 더한다.
 * 물론 A를 right 로 B를 left 로 두고 연산해도 문제 없음
 */
public class BOJ_2143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int AN = Integer.parseInt(br.readLine());
        String []inputA = br.readLine().split(" ");
        int [] A = new int[AN];
        for(int i=0; i<AN; i++){
            A[i] = A[i] + Integer.parseInt(inputA[i]);
        }

        int BN = Integer.parseInt(br.readLine());
        String []inputB = br.readLine().split(" ");
        int [] B = new int[BN];
        for(int i=0; i<BN; i++){
            B[i] = B[i] + Integer.parseInt(inputB[i]);
        }

        long result = solution(T, A, B);

        System.out.println(result);
    }

    private static long solution(int T,int [] A, int [] B) {
        Map<Integer, Integer> aCnt = new HashMap<>();
        Map<Integer, Integer> bCnt = new HashMap<>();

        for(int i=0; i<A.length; i++){
            int sum = 0;
            for(int j=i; j<A.length; j++){
                sum += A[j];
                aCnt.put(sum, aCnt.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i=0; i<B.length; i++){
            int sum = 0;
            for(int j=i; j<B.length; j++){
                sum += B[j] ;
                bCnt.put(sum, bCnt.getOrDefault(sum, 0) + 1);
            }
        }

        List<Integer> AList = new ArrayList<>(aCnt.keySet());
        List<Integer> BList = new ArrayList<>(bCnt.keySet());
        Collections.sort(AList);
        Collections.sort(BList);

        long result = 0;
        int left = 0;
        int right = BList.size() - 1;

        while(left < AList.size() && right >=0){
            int curA = AList.get(left);
            int curB = BList.get(right);
            int sum  =curA + curB;

            if(sum == T){
                int aCount = aCnt.get(curA);
                int bCount = bCnt.get(curB);

                result += ((long) aCount * bCount);
                left++;
                right--;
            }else if(sum < T){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }
}
