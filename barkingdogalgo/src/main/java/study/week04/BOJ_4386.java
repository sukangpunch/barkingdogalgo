package study.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 별자리 만들기
public class BOJ_4386 {

    static class Point{
        int num;
        double x;
        double y;

        public Point(int num, double x,double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge{
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point [] points = new Point[N];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            double x = Float.parseFloat(s[0]);
            double y = Float.parseFloat(s[1]);

            points[i] = new Point(i, x,y);
        }

        pq = new PriorityQueue<>((e1, e2) -> {
            if(e1.weight < e2.weight) return -1;
            return 1;
        });

        for (int i=0; i<N; i++){
            for (int j = i+1; j<N; j++){
                double weight = distance(points[i], points[j]);
                pq.add(new Edge(points[i].num, points[j].num, weight));
            }
        }

        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }

        double ans = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            double cost = edge.weight;

            if(find(start) != find(end)){
                ans += cost;
                union(start, end);
            }
        }

        System.out.println(ans);

    }

    public static void union(int x, int y){
        int rootA = find(x);
        int rootB = find(y);
        parent[Math.min(rootA, rootB)] = Math.max(rootA, rootB);
    }

    private static int find(int x) {
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
