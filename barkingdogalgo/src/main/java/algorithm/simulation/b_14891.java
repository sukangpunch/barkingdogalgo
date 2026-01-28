package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 톱니바퀴
public class b_14891 {

    static boolean [][] gear = new boolean[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++){
            String s = br.readLine();
            setGear(i, s);
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            String [] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]) - 1;
            int direction = Integer.parseInt(s[1]);
            startGear(n, direction);
        }

        int answer = gearCheck();
        System.out.println(answer);
    }

    private static int gearCheck() {
        int answer = 0;
        for(int i=0; i<4; i++){
            if(gear[i][0])
                answer += (int) Math.pow(2, i);
        }
        return answer;
    }

    private static void startGear(int idx, int direction) {
        boolean magnet = gear[idx][2];
        int nDirection = direction;

        for(int i=idx+1; i<4; i++){
            if(gear[i][6] != magnet){
                magnet = gear[i][2];
                nDirection *= -1;
                rotate(i, nDirection);
            }else
                break;
        }
        magnet = gear[idx][6];
        nDirection = direction;

        for(int i= idx-1; i>=0; i--){
            if(gear[i][2] != magnet){
                magnet = gear[i][6];
                nDirection *= -1;
                rotate(i, nDirection);
            }else
                break;
        }
        rotate(idx, direction);
    }

    private static void rotate(int idx, int rotate) {
        boolean temp;
        if(rotate == 1){
            temp = gear[idx][7];
            for(int i=7; i>0; i--)
                gear[idx][i] = gear[idx][i-1];
            gear[idx][0] = temp;
        }else{
            temp = gear[idx][0];
            for(int i=0; i<7; i++)
                gear[idx][i] = gear[idx][i+1];
            gear[idx][7] = temp;
        }
    }

    private static void setGear(int idx, String s) {
        for(int i=0; i<8; i++){
            if(s.charAt(i) == '1')
                gear[idx][i] = true;
            else
                gear[idx][i] = false;
        }
    }
}
