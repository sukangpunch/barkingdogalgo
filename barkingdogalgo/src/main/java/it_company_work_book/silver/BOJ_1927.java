package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
// 자료구조, 우선순위 큐
/**
 * import java.util.PriorityQueue; 을 사용하면 되지만, heap을 직접 구현,
 * push 할때는 size를 늘리고, heap의 끝에 요소를 추가 하고, 업-힙
 * pop 할때는 root 값을 저장하고, 마지막 요소를 root에 두고, 사이즈를 줄이고, 다운-힙
 */
public class BOJ_1927 {

    static class MyHeap{
        private int [] heap;
        private int size;

        public MyHeap(){
            this.heap = new int[100001];
            this.size = 0;
        }

        // 업힙 - 가장 아래에 요소를 push 하고 위치에 맞게 올린다.
        // 배열 기반 힙에서 완전 이진 트리 구조를 유지하며 요소를 추가하는 방법은, 힙에서 마지막에 추가하는 것이기 때문
        // 또한, 마지막에 넣으면 트리 구조는 정상, 부모 <= 자식 조건만 깨질 수 있는 것. 
        // 깨질 수 있는 위치는 자기자신 -> 루트 경로만 해당
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

        // 다운 힙 - root 를 출력하고, 가장 끝 요소를 root에 둔 다음, 위치에 맞게 내리는 방법
        // 루트를 삭제하면 트리 구조가 깨지는데, 마지막 노드를 루트로 올려서 트리 구조를 유지
        // 이제 깨질 수 있는 부분은 루트에서 아래 방향 경로 하나이다.
        // 또한 두 자식중에 더 작은 애랑 바꾸는 것은, 부모<=자식을 만족해야 하니까, 큰 자식이랑 바꾸면, 힙 속성이 깨질 수 있다.
        int pop(){
            if(size == 0){
                return 0;
            }

            int x = heap[1];
            heap[1] = heap[size--];
            int parent = 1;
            while(2*parent <= size){
                int leftChild = parent*2;
                int rightChild = parent*2+1;

                int minChild = leftChild;
                if(rightChild <= size && heap[rightChild] < heap[leftChild]){
                    minChild = rightChild;
                }

                if(heap[parent] <= heap[minChild])break;

                int tmp = heap[parent];
                heap[parent] = heap[minChild];
                heap[minChild] = tmp;

                parent = minChild;
            }
            
            return x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyHeap heap = new MyHeap();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                sb.append(heap.pop()).append("\n");
            }else{
                heap.push(num);
            }
        }

        System.out.println(sb);
    }
}
