package soma.second;

import java.util.ArrayList;
import java.util.List;

// 이모티콘 할인 행사
// 백트래킹, 구현

/**
 *  시간복잡도가 O(4^N x M x N) 이지만, N이 최대 7, M이 최대 100, 할인률은 4가지 이므로 최대 1100만번이라 괜찮다.
 *  동작 방식은 다음과 같다.
 *  1. 할인률은 10, 20 ,30, 40 퍼센트이므로 값을 담은 discount 리스트 생성, 최종 money와 plus 요금제 수를 저장할 정적 변수 선언
 *  2. 백트래킹 기저 조건은 할인률과 이모티콘 수가 같을 때, 유저 한명당 이모티콘들을 비교하여, 유저의 최저 할인률 기준에 맞는 이모티콘들을 할인한 가격을 sum에 저장
 *  3. 만약 해당 유저의 sum 값이 유저의 최고 금액 이상이면 sum값을 버리고 plus 요금제로 변환(plus++)
 *  4. 최종적으로 해당 할인률(백트래킹으로 쌓아온) 에 대하여 nowplus와 nowmoney값이 최종 결과 plus보다 크거나, 같다면 money가 더 큰 상황이면 max값으로 업데이트(plus요금제가 더 우선순위)
 *  5. 백트래킹하여 모든 조합을 확인한 다음 최종으로 남은 money와 plus가 최대 효율
 */
public class PGS_150368 {

    public static void main(String[] args) {

        int [][]users = {{40, 10000}, {25, 10000}};
        int [] emoticons = {7000, 9000};
        int[] result = solution(users, emoticons);

        System.out.println(result[0] + " " + result[1]);
    }

    static List<Integer> discount;
    static int money;
    static int plus;

    static public int[] solution(int[][] users, int[] emoticons) {
        money = 0;
        plus = 0;
        discount = new ArrayList<>();
        discount.add(10);
        discount.add(20);
        discount.add(30);
        discount.add(40);

        backtrack(users, emoticons);

        return new int[]{plus, money};
    }

    static List<Integer> list = new ArrayList<>();

    static void backtrack(int [][] users, int [] emoticons){
        if(list.size() == emoticons.length){
            int nowMoney = 0;
            int nowPlus = 0;
            for(int i=0; i<users.length; i++){
                int percent = users[i][0];
                int maxMoney = users[i][1];
                int sum = 0;

                for(int j=0; j<emoticons.length; j++){
                    int price = emoticons[j];
                    int discount = list.get(j);
                    if(discount < percent){
                        continue;
                    }
                    int total = price * (100-discount)/100;
                    sum += total;
                }

                if(sum < maxMoney){
                    nowMoney += sum;
                }else{
                    nowPlus++;
                }
            }

            if(plus < nowPlus){
                plus = nowPlus;
                money = nowMoney;
            }else if(plus == nowPlus && money < nowMoney){
                money = nowMoney;
            }

            return;
        }

        for(int i=0; i<discount.size(); i++){
            list.add(discount.get(i));
            backtrack(users, emoticons);
            list.remove(list.size()-1);
        }
    }
}
