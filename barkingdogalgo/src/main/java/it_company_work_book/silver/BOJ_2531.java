package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회전초밥
// 투포인터, 브루트포스, 슬라이딩 윈도우
/**
 * 현 윈도우 상태에 맞게 현재 먹은 스시 개수 및 중복을 처리할 sushiCounts 배열을 두고,
 * 중복과 쿠폰을 고려해서 겹치지 않는 스시 개수를 구할 uniqueCount 을 둔다.
 * 초기 슬라이딩 윈도우 값을 구한 다음, 해당 값에서 인덱스를 1씩 이동해가며 윈도우의 처음 인덱스 값을 윈도우의 다음 인덱스를 추가한다.
 * 원형 배열이기 때문에 %연산을 통해서 범위를 지정한다.
 */
public class BOJ_2531  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int c = Integer.parseInt(s[3]);

        int [] dishes = new int[N];

        for(int i=0; i<N; i++){
            int dish = Integer.parseInt(br.readLine());
            dishes[i] = dish;
        }

        int [] sushiCounts = new int[d+1]; // 각 초밥 종류별 먹은 개수
        int uniqueCount = 0; // 현재 윈도우 내 고유한 초밥의 개수
        
        for(int i=0; i<k; i++){
            if(sushiCounts[dishes[i]] == 0){
                uniqueCount++; // 처음 먹어보는 종류라면 증가
            }
            sushiCounts[dishes[i]]++;
        }

        int maxCount = uniqueCount;

        // 먹은 초밥에 쿠폰 초밥이 없다면 +1
        if(sushiCounts[c] == 0){
            maxCount = Math.max(maxCount, uniqueCount + 1);
        }

        for(int i=0; i<N; i++){
            int removeDish = dishes[i];
            sushiCounts[removeDish]--;
            if(sushiCounts[removeDish] == 0){ // 더이상 이 종류의 초밥이 윈도우에 없다면
                uniqueCount--;
            }

            // 새로 들어오올 초밥 추가, 원형 배열이므로 %로 인덱스 처리
            int addDish = dishes[(i+k) %N];
            if(sushiCounts[addDish] == 0){
                uniqueCount++;
            }
            sushiCounts[addDish]++;

            // 최대 가짓수 갱신 (쿠폰 초밥 포함 여부 확인)
            int currentMax = uniqueCount;
            if(sushiCounts[c] == 0){
                currentMax++;
            }
            maxCount = Math.max(maxCount, currentMax);
        }

        System.out.println(maxCount);

    }
}
