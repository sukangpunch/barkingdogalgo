package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 창고 다각형
// 구현, 브루트 포스, 스택

/**
 * 못풀어서 답지 봄. 접근은 맞았으나 계산에서 뇌정지가 왔다.
 * 움푹 파인 지붕이 없어야 하는 것 이므로 가장 높은 지붕을 찾고, 해당 부분으로부터 왼쪽, 오른쪽 부분이
 * 계단식으로 줄어들어야 한다. , 즉 왼쪽 탐색 시 가장 높은 좌표까지 높이 최댓값이 업데이트 될 때마다 넓이를 구해서 result에 더한다.
 * 오른쪽도, 끝에서부터 시작해서 자기보다 더 큰 height 이 나오면 이전 좌표와 지금 좌표 기반 넓이를 구하고 더한다.
 * 마지막으로 가장 높은 높이는 단 하나만 남기고 연산이 종료되기 때문에(같은 높이가 여러개 있는건, 연산중 계산이 되어있는 상태, 오직 한개만 남음)
 * 1*높이를 하여 더해주면 완료
 */
public class BOJ_2304 {

    static class Pillar{
        int locate;
        int height;

        public Pillar(int locate, int height){
            this.locate = locate;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Pillar> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String []s = br.readLine().split(" ");
            int L = Integer.parseInt(s[0]);
            int H = Integer.parseInt(s[1]);
            list.add(new Pillar(L, H));
        }

        Collections.sort(list, (o1, o2) -> o1.locate - o2.locate);

        int sum = 0;
        int maxHeightPoint = 0;
        Pillar max = list.get(0);
        for(int i=1; i<list.size(); i++){
            Pillar current = list.get(i);

            if(max.height <= current.height){
                sum += (current.locate - max.locate) * max.height;
                max = current;
                maxHeightPoint = i;
            }
        }

        max = list.get(list.size()-1);
        for(int i = 1; i<list.size() - maxHeightPoint; i++){
            Pillar current = list.get(list.size() -1 -i);

            if(max.height <= current.height){
                sum += (max.locate - current.locate) * max.height;
                max = current;
            }
        }

        sum += list.get(maxHeightPoint).height;

        System.out.println(sum);
    }
}
