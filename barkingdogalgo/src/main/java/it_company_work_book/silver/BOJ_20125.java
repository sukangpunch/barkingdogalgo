package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿠키의 신체 측정
// 구현

/**
 * 그냥 구현 문제
 * 심장은 무조건 해당 배열의 첫 번째 * 를 찾았을 때 바로 아래에 위치한다.
 * 이후, 심장을 기준으로 왼쪽, 오른쪽, 아래가 왼쪽팔, 오른쪽 팔, 몸통이다
 * 몸통의 가장 아래 부분에서 왼쪽 아래, 오른쪽 아래 부분이 다리 이다.
 * 이를 하나하나 구현해주면 된다.
 */
public class BOJ_20125 {

    static int N;
    static Character [][] cookie;
    static int leftArm = 0;
    static int rightArm = 0;
    static int body = 0;
    static int leftLeg = 0;
    static int rightLeg = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cookie = new Character[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                cookie[i][j] = s.charAt(j);
            }
        }

        boolean check = false;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(cookie[i][j] == '*'){
                    measureCookie(i+1, j);
                    sb.append((i+1) + 1).append(" ").append(j + 1).append("\n");
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        sb.append(leftArm).append(" ")
                .append(rightArm).append(" ")
                .append(body).append(" ")
                .append(leftLeg).append(" ")
                .append(rightLeg).append(" ");
        System.out.println(sb);
    }

    private static void measureCookie(int y, int x) {
        int dy = y;
        int dx = x;
        while(true){
            dx -=1;
            if(dx<0 || cookie[dy][dx] != '*')break;
            leftArm++;
        }

        dy = y;
        dx = x;
        while(true){
            dx += 1;
            if(dx>=N || cookie[dy][dx] != '*')break;
            rightArm++;
        }

        dy = y;
        dx = x;
        while(true){
            dy += 1;
            if(dy>=N || cookie[dy][dx] !='*')break;
            body++;
        }

        int lLegDy = dy+1;
        int lLegDx = dx-1;
        while(true){
            leftLeg++;
            if(lLegDy>=N || cookie[lLegDy][lLegDx] != '*')break;
            lLegDy += 1;
        }

        int rLegDy = dy+1;
        int rLegDx = dx+1;
        while(true){
            rightLeg++;
            if(rLegDy >=N || cookie[rLegDy][rLegDx] != '*')break;
            rLegDy += 1;
        }
    }
}
