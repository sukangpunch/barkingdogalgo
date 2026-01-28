package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 국영수
public class b_10825_comparable {

    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public int getKor() {
            return this.kor;
        }

        public int getEng() {
            return this.eng;
        }

        public int getMath() {
            return this.math;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public int compareTo(Student other) {
            // return 결과가 음수면 this가 other보다 앞(작은인덱스) 에 위치
            // return 결과가 양수면 this가 other 보다 뒤(큰인덱스) 에 위치
            // return 결과가 0이면 변동x

            if(this.kor != other.kor){
                return other.kor - this.kor; // 내림차순
            }
            if(this.eng != other.eng){
                return this.eng - other.eng; // 오름차순
            }
            if(this.math != other.math){
                return other.math - this.math; // 내림차순
            }
            return this.name.compareTo(other.name); // 오름차순
        }
    }

    static List<Student> students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        students = new ArrayList<>();
        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            String name = line[0];
            int kor = Integer.parseInt(line[1]);
            int eng = Integer.parseInt(line[2]);
            int math = Integer.parseInt(line[3]);
            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students);

        for(int i=0; i<N; i++){
            sb.append(students.get(i).getName()).append("\n");
        }

        System.out.println(sb);
    }

}
