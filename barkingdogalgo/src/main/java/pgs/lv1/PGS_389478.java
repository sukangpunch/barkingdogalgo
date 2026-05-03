package pgs.lv1;

// 택배 상자 꺼내기

/**
 * 처음엔 수식으로만 풀려고 했다가 그냥 map 만들어서 완전탐색으로 해결
 * 요구사항 기반으로 쌓인 상자 그대로 배열로 나타냄
 * 나누기 연산 시, 나머지가 존재하는 경우는 map 높이를 1추가하고 나머지 데이터를 입력
 * 배열 값을 채울 때, 왼쪽 오른쪽 기준을 명확히 한다, 또한 target의 idx 를 미리 저장
 * 이후 만들어진 map과 target의 idx 기반으로 r 값을 1씩 증가시키면서 값이 존재하는지 확인하면 위에 있는 상자 개수를 알 수 있음.
 */
public class PGS_389478 {

    public static void main(String[] args) {
        int n = 13;
        int w = 3;
        int num = 6;

        int result = solution(n, w, num);

        System.out.println(result);
    }

    static public int solution(int n, int w, int num) {
        int high = n/w;
        int bias = n - (high*w);
        int rSize = bias == 0 ? high : high+1;

        int [][]map = new int[rSize][w];

        int value = 1;
        boolean isLeft = true;
        int targetX = -1;
        int targetY = -1;
        for(int i=0; i<rSize; i++){
            if(isLeft){
                for(int j=0; j<w; j++){
                    if(value>n)break;
                    if(value == num){
                        targetX = i;
                        targetY = j;
                    }
                    map[i][j] = value;
                    value +=1;
                }
            }else{
                for(int j=w-1; j>=0; j--){
                    if(value>n)break;
                    if(value == num){
                        targetX = i;
                        targetY = j;
                    }
                    map[i][j] = value;
                    value +=1;
                }
            }

            isLeft = !isLeft;
        }

        int result = 1;
        while(true){
            targetX +=1;
            if(rSize <= targetX || map[targetX][targetY] == 0){
                break;
            }

            result++;
        }

        return result;
    }
}
