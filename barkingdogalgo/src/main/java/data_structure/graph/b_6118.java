package data_structure.graph;

import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_6118 {
    static int N;
    static int M;
    static int [] distances;
    static ArrayList<ArrayList<Integer>> graph;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distances = new int[N+1];

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        find();
        print();
        br.close();
    }

    static void find() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        Arrays.fill(distances, MAX_VALUE);
        distances[1] = 0;

        while (!q.isEmpty()) {
            int start = q.poll();

            for(int node: graph.get(start)) {
                if(distances[node] > distances[start] + 1) {
                    distances[node] = distances[start] + 1;
                    max = Math.max(max, distances[node]);
                    q.add(node);
                }
            }
        }
    }

    static void print(){
        int count = 0;
        int first = 0;

        for(int i = 1; i <= N; i++) {
            if(distances[i] == max) {
                count++;
                if(first == 0) {
                    first = i;
                }
            }
        }
        System.out.println(first + " " + max + " " + count);
    }
}
