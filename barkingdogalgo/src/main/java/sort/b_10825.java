package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 국영수
public class b_10825 {
    static class Student{
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

        students.sort(Comparator.comparingInt(Student::getKor).reversed()// comparingInt(Student::getKor) 가 만든 Comparator 만 뒤집음
                              .thenComparingInt(Student::getEng)
                              .thenComparing(Comparator.comparingInt(Student::getMath).reversed()) // comparingInt(Student::getMath) 가 만든 Comparator 만 뒤집음
                              .thenComparing(Student::getName));

        for(int i=0; i<N; i++){
            sb.append(students.get(i).getName()).append("\n");
        }

        System.out.println(sb);
    }
}
