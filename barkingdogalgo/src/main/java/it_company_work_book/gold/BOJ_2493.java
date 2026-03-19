package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 탑
// 스택

/**
 * 시간복잡도 : O(N) / 최대 put N번 최대 pop N번
 * 과거에 푼 적이 있어서 쉽게 풀었다.
 * 스택을 활용해서 규칙에 맞게 비교하고 push, pop 하면 된다.
 * 비교 기준은 스택에 있는 탑보다 현재 탐색 탑이 더 높으면 스택의 top을 pop 한다.
 * 스택에 있는 탑보다 현재 탑이 작으면 스택에 push 하고(해당 탑보다 더 낮은 탑이 존재하면 해당 탑에 막히기 떄문) 스택에 있는 탑의 인덱스를 sb에 저장
 * 스택 탐색 시 스택이 비어있다면 레이저가 걸리는 탑이 없으므로 0을 sb에 추가
 */
public class BOJ_2493 {

    static class Top{
        int num;
        int h;

        public Top(int num , int h){
            this.num = num;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String []s = br.readLine().split(" ");
        Stack<Top> st = new Stack<>();

        for(int i=0; i<N; i++){
            int top = Integer.parseInt(s[i]);

            if(st.isEmpty()){
                st.add(new Top(i+1, top));
                sb.append(0).append(" ");
            }else{
                while(true){
                    if(st.isEmpty()){
                        st.push(new Top( i+1, top));
                        sb.append(0).append(" ");
                        break;
                    }

                    if(st.peek().h < top){
                        st.pop();
                    }else{
                        Top tmp = st.peek();
                        sb.append(tmp.num).append(" ");
                        st.push(new Top(i+1, top));
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
