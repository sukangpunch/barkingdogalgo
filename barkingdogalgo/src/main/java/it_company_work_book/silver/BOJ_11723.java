package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 집합
// 구현, 집합과 맵, 비트마스킹

/**
 * 집합과 맵으로 해결
 * 어려운 부분은 없었다.
 */
public class BOJ_11723 {

    static class EmptySet{
        Set<Integer> set;

        public EmptySet(){
            this.set = new HashSet<>();
        }

        public void add(int x){
            set.add(x);
        }

        public void remove(int x){
            set.remove(x);
        }

        public int check(int x){
            if(set.contains(x)){
                return 1;
            }
            return 0;
        }

        public void toggle(int x){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }

        public void all(){
            Set<Integer> newSet = new HashSet<>();
            for(int i=1; i<=20; i++){
                newSet.add(i);
            }
            this.set = newSet;
        }

        public void empty(){
            this.set = new HashSet<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        EmptySet es = new EmptySet();

        for(int i=0; i<M; i++){
            String []s = br.readLine().split(" ");
            switch(s[0]){
                case "add": es.add(Integer.parseInt(s[1]));break;
                case "remove": es.remove(Integer.parseInt(s[1]));break;
                case "check": sb.append(es.check(Integer.parseInt(s[1]))).append("\n");break;
                case "toggle": es.toggle(Integer.parseInt(s[1]));break;
                case "all" : es.all();break;
                case "empty": es.empty();break;
            }
        }

        System.out.println(sb);
    }
}
