package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Philosopher’s Walk
public class b_14956_retry {

    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        Point result = findPoint(N, M);
        System.out.println(result.x + " " + result.y);
    }

    private static Point findPoint(int side, int step) {
        if(side == 2){
            switch(step){
                case 1:
                    return new Point(1, 1);
                case 2:
                    return new Point(2, 1);
                case 3:
                    return new Point(2, 2);
                case 4:
                    return new Point(1, 2);
            }
        }

        int size = side/2;
        int partSize = size * size;

        if(step <= partSize){
            Point pt = findPoint(size, step);
            return new Point(pt.x, pt.y);
        }
        else if(step <= 2 * partSize){
            Point pt = findPoint(size, step - partSize);
            return new Point(pt.y + size, pt.x);
        }else if(step <= 3 * partSize){
            Point pt = findPoint(size, step - (2 * partSize));
            return new Point(pt.y + size, pt.x + size);
        }else{
            Point pt = findPoint(size, step - (3 * partSize));
            return new Point(size - pt.x + 1, (2*size) - pt.y + 1);
        }
    }
}
