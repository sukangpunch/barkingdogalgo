package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 선 긋기
public class b_2170 {

    static class Line{
        int x;
        int y;

        public Line(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }
    }

    static List<Line> points;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        points = new ArrayList<>();
        length = 0;

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            points.add(new Line(x, y));
        }

        points.sort(
                Comparator.comparingInt(Line::getX)
                        .thenComparing(Line::getY)
        );

        findLineLength();

        System.out.println(length);
    }

    private static void findLineLength() {
        int preEnd = Integer.MIN_VALUE;

        for(int i=0; i<points.size(); i++){
            Line line = points.get(i);
            int start = line.x;
            int end = line.y;

            if(start >= preEnd){
                length += end - start;
                preEnd = end;
            }else if(end <= preEnd){
                continue;
            }else{
                start = preEnd;
                length += end - start;
                preEnd = end;
            }
        }
    }
}
