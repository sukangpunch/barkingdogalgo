package barkingdog_youtube.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최소 힙
public class b_1927_learn {

    static class Heap{
        int [] heap;
        int size;

        public Heap(){
            this.heap = new int[1000005];
            this.size = 0;
        }

        void push(int x){
            heap[++size] = x;
            int child = size;

            while(child != 1){
                int parent = child/2;
                if(heap[parent] <= heap[child])break;
                int tmp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = tmp;
                child = parent;
            }
        }

        int pop(){
            if(size == 0){ // size 가 0이면 바로 종료
                return 0;
            }

            int x = heap[1];
            heap[1] = heap[size--];
            int parent = 1;
            while(2*parent <= size){ // 자식 없으면 바로 종료
                int leftChild = parent * 2;
                int rightChild = parent * 2 + 1;

                int minChild = leftChild;

                if(rightChild <= size && heap[rightChild] < heap[leftChild]){
                    minChild = rightChild;
                }

                if(heap[parent] <= heap[minChild]) break;

                int tmp = heap[parent];
                heap[parent] = heap[minChild];
                heap[minChild] = tmp;

                parent = minChild;
            }
            return x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Heap heap = new Heap();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                int x = heap.pop();
                sb.append(x).append("\n");
            }else{
                heap.push(num);
            }
        }

        System.out.println(sb);
    }
}
