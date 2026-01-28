package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 톱니바퀴
public class b_14891_retry {

    static boolean [][] cogWheels;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cogWheels = new boolean[4][8];

        for(int i = 0; i < 4; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++) {
                if(s.charAt(j) == '1') {
                    cogWheels[i][j] = true;
                }else{
                    cogWheels[i][j] = false;
                }
            }
        }

        k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            String []s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]) - 1;
            int d = Integer.parseInt(s[1]);
            rotationCogWheels(n, d);
        }

        int result = calculateScore();

        System.out.println(result);
    }

    private static int calculateScore() {
        int result = 0;
        for(int i = 0; i < 4; i++) {
            result += cogWheels[i][0] ? (int) Math.pow(2, i) : 0;
        }
        return result;
    }

    private static void rotationCogWheels(int n , int direction) {
        boolean magnet = cogWheels[n][2];
        int nDirection = direction;
        for(int idx = n+1; idx < 4; idx++) {
            if(magnet != cogWheels[idx][6]) {
                magnet = cogWheels[idx][2];
                nDirection *= -1;
                rotation(idx, nDirection);
            }else{
                break;
            }
        }

        magnet = cogWheels[n][6];
        nDirection = direction;
        for(int idx = n-1; idx >= 0; idx--) {
            if(magnet != cogWheels[idx][2]) {
                magnet = cogWheels[idx][6];
                nDirection *= -1;
                rotation(idx, nDirection);
            }else {
                break;
            }
        }

        rotation(n, direction);
    }

    private static void rotation(int idx, int rotation) {
        boolean temp;
        if(rotation == 1){
            temp = cogWheels[idx][7];
            for(int i = 7; i > 0; i--) {
                cogWheels[idx][i] = cogWheels[idx][i-1];
            }
            cogWheels[idx][0] = temp;
        }else{
            temp = cogWheels[idx][0];
            for(int i=0; i<7; i++){
                cogWheels[idx][i] = cogWheels[idx][i+1];
            }
            cogWheels[idx][7] = temp;
        }
    }
}
