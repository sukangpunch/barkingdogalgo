package study.week13;

import java.util.Arrays;

// 길 찾기 게임
// 이진 트리

/**
 * 시간복잡도: O(NlogN)
 * Node 클래스의 정렬 기준은  y값이 크면 부모 노드가 되며, x값 기준으로 왼쪽 자식, 오른쪽 자식이 결정된다.
 * n.y -this.y 로 y좌표 기준으로 내림차순 정렬합니다, this.x -n.x 는 y좌표가 같다면 x좌표 기준으로 오름차순 정렬합니다.
 * insertNode 를 통해 이진트리를 만듭니다. 왼쪽 자식, 오른쪽 자식인지 판별 후 비어있으면 연결, 아니면 타고 내려감
 * 이후 완성된 이진트리를 기반으로 전위, 후위 순회
 * 전위 순회 : 루트 -> 왼쪽자식 -> 오른쪽자식 순서 방문
 * 후위 순회 : 왼쪽 -> 오른쪽 -> 루트 순서로 방문
 */
public class PGS_42892 {
    class Solution {
        static class Node implements Comparable<Node>{
            int v;
            int x;
            int y;
            Node left;
            Node right;
            Node(int v, int x, int y, Node left, Node right){
                this.v = v;
                this.x = x;
                this.y = y;
                this.left = left;
                this.right = right;
            }

            @Override
            public int compareTo(Node n){
                if(this.y == n.y){
                    return this.x - n.x;
                }

                return n.y - this.y;
            }
        }

        int preIdx = 0;
        int postIdx = 0;

        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = {};
            int size = nodeinfo.length;
            Node[] nodes = new Node[size];
            for(int i=0; i<nodeinfo.length; i++){
                nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
            }

            Arrays.sort(nodes);

            Node parent = nodes[0];
            for(int i=1 ; i<size; i++){
                insertNode(parent, nodes[i]);
            }

            answer = new int[2][size];
            preorder(parent, answer[0]);
            postorder(parent, answer[1]);

            return answer;
        }

        public void insertNode(Node parent, Node child){
            if(parent.x > child.x){
                if(parent.left == null)parent.left = child;
                else insertNode(parent.left, child);
            }else{
                if(parent.right == null)parent.right = child;
                else insertNode(parent.right, child);
            }
        }

        public void preorder(Node node, int[] pre){
            if(node != null){
                pre[preIdx++] = node.v;
                preorder(node.left, pre);
                preorder(node.right, pre);
            }
        }

        public void postorder(Node node, int[] post){
            if(node != null){
                postorder(node.left, post);
                postorder(node.right, post);
                post[postIdx++] = node.v;
            }
        }
    }
}
