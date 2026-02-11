package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주유소
// 그리디
/**
 * 처음에 브루트포스로 구하려다가 너무 복잡해 보여서 그리디를 생각하였다.
 * 일단 첫번째 주유소에서 두번 째 주유소의 거리만큼 주유하는 것은 당연하므로 처리
 * 그 다음부터는 minIdx에 가장 싼 주유소를 넣고, 현재 탐색하는 주유소와 비교하여 더 값 싼 주유소에서 다음 거리까지의 km만큼 주유
 * 만약 minIdx에 해당하는 도시가 i보다 비싸다면, minIdx를 i로 업데이트하고, minIdx에 해당하는 도시 리터당 가격으로 다음 도시까지 키로미터 가격 계산
 */
public class BOJ_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String []s = br.readLine().split(" ");
        long []roadLength = new long[N];
        for(int i=1; i<N; i++){
            roadLength[i] = Integer.parseInt(s[i-1]);
        }

        s = br.readLine().split(" ");
        long [] cities = new long[N];
        for(int i=0; i<N; i++){
            cities[i] = Integer.parseInt(s[i]);
        }

        long result = cities[0] * roadLength[1];
        int minIdx = 0;
        for(int i=1; i<N-1; i++){
            if(cities[minIdx] >= cities[i]){
                result += cities[i] * roadLength[i+1];
                minIdx = i;
            }else{
                result += cities[minIdx] * roadLength[i+1];
            }
        }
        System.out.println(result);
    }
}
