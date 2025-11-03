package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 확인: o
/**
 * 4방향으로 범위를 나누고(분할 정복) 범위에 찾으려고 하는 값이 포함 된다면,
 * 해당 범위에서 또 4 분할로 나눈다.
 * 나눈 범위에서 최소 기준 2x2 사이즈이며, 찾으려고 하는 값이 포함된다면, 정 방향 step을 리턴한다.
 * 정방향 step 이 리턴 되고, depth 를 줄여 나가며 다시 리턴 될 때, 범위 별 변동사항을 적용한다.
 * 예) 1사분면은 2일때 정방향 4일때 시계방향 8일때 시계방향이 된다.
 * 예) 2사분면은 2일때 정방향 4일때 정방향 8일떄도 정방향이 된다.
 * 예) 3사분면은 2일때 정방향 4일떄 정방향 8일때도 정방향이 된다.
 * 예) 4사분면은 2일때 정방향 4일때 반시계방향 8일때 반시계 방향이 된다.
 */
public class b_14956 {

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Point result = findPoint(n, m);
        System.out.println(result.x + " " + result.y);
    }

    private static Point findPoint(int side, int step) {
        if(side == 2){
            switch(step){
                case 1:
                    return new Point(1, 1);
                case 2:
                    return new Point(1, 2);
                case 3:
                    return new Point(2, 2);
                case 4:
                    return new Point(2, 1);
            }
        }

        int size = side/2;
        int partSize = size * size;

        if(step <= partSize){
            Point pt = findPoint(size, step);
            return new Point(pt.y, pt.x);
        }
        else if(step <= 2 * partSize){
            Point pt = findPoint(size, step - partSize);
            return new Point(pt.x, pt.y + size);
        }else if(step <= 3 * partSize){
            Point pt = findPoint(size, step - (2 * partSize));
            return new Point(pt.x + size, pt.y + size);
        }else{
            Point pt = findPoint(size, step - (3 * partSize));
            return new Point((2*size) - pt.y + 1, size - pt.x + 1);
        }
    }

}
