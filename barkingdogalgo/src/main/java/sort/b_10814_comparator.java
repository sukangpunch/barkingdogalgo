package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 나이순 정렬

public class b_10814_comparator {
    static class Member {
        int age;
        int order;
        String name;

        public Member(int age, int order, String name){
            this.age = age;
            this.order = order;
            this.name = name;
        }
        public int getAge() {
            return age;
        }

        public int getOrder() {
            return order;
        }
    }

    static int N;
    static List<Member> members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        members = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            String [] s = br.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];
            members.add(new Member(age,i,name));
        }

        members.sort(Comparator.comparingInt(Member::getAge)
                             .thenComparingInt(Member::getOrder));

        for(int i=0 ; i<N ; i++){
            int age = members.get(i).age;
            String name = members.get(i).name;
            sb.append(age).append(" ").append(name).append("\n");
        }

        System.out.println(sb);
    }

}
