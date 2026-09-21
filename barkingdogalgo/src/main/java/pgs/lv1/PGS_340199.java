package pgs.lv1;

// PCCE 기출문제 지폐 집기

/**
 * 지갑 사이즈에 맞게 지폐를 접어야하는 문제.
 * 지폐를 접을 때 긴변을 접어야 하고, 90도로 돌려서 지갑에 들어갈 수 있으면 ok(즉, 방향이 중요한게 아니라 지갑의 긴변, 지폐의 긴변을(반대도) 비교해야하는 것)
 * 그래서 Math.max, Math.min 을 활용해서 가로 세로가 아닌 긴변, 짧은 변으로 값을 가져와서 긴변끼리, 짧은변끼리 비교해서 지갑에 들어갈 수 있으면 break.
 * 지갑에 들어갈 수 없으면 bill 배열에 긴변/2 와 짧은변 값을 덮어쓰기. 어짜피 max, min 으로 값을 빼기때문에 순서는 상관 x
 */
public class PGS_340199 {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while(true){
            int maxWallet = Math.max(wallet[0], wallet[1]);
            int minWallet = Math.min(wallet[0], wallet[1]);
            int maxBill = Math.max(bill[0],bill[1]);
            int minBill = Math.min(bill[0], bill[1]);

            if(maxWallet>= maxBill && minWallet >= minBill){
                break;
            }

            bill[0] = maxBill/2;
            bill[1] = minBill;
            answer++;
        }

        return answer;
    }

}
