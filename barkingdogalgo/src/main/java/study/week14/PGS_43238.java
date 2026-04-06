package study.week14;

// 입국 심사
// 이분 탐색

/**
 * 이분 탐색이라는 걸 알고 풀었다.
 * times 에서 최대값을 찾고 최대의 시간을 소요하는 값(최대시간 * 인원수) 를 right로 둔다.
 * 이분탐색을 돌리는데 비교 값은 선택된 mid 기반으로 각 time 들이 mid 시간 내 몇명을 처리할 수 있는지를 합산하여
 * 해당 결과가 실제 처리해야하는 인원수보다 작으면 left값을 올리고, 크다면 answer를 업데이트하고 right값을 mid 로 한다.
 * 크거나 같으면 업데이트하고, mid-1이 아닌 mid로 하는 이유는,
 * 적합한 시간 즉, 최소값을 찾는 이분 탐색에서 우리가 찾는 건 check(mid) >= n 을 만족하는(n보다 작으면 불가능) 가장 작은 값이기 때문이다.
 * 또한 mid-1을 하게 되면 유일한 정답을 잃어버릴 수도 있기 때문에 정답 후보군을 유지하는 것
 */
public class PGS_43238 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            long left = 0;
            long right = 0;

            for(int time: times){
                if(right < time){
                    right = time;
                }
            }

            right = right * n;

            answer = binary(left, right, times, n);

            return answer;
        }

        static long binary(long left, long right, int[] times, int n){

            long result = 0;
            while(left < right){
                long mid = (left+right)/2;
                long sum = check(mid, times);

                if(sum < n){
                    left = mid+1;
                }else{
                    result = mid;
                    right = mid;
                }
            }

            return result;
        }

        static long check(long total, int []times){
            long sum = 0;

            for(int time : times){
                sum += total/time;
            }

            return sum;
        }
    }
}
