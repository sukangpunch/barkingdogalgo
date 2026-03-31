package soma.first;

import java.util.PriorityQueue;
import org.jetbrains.annotations.NotNull;

public class SM_PriorityQueue {

    static class MyMember implements Comparable<MyMember>{
        String name;
        int age;

        public MyMember(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(MyMember o) {
            return this.age-o.age;
        }

    }

    static class Student implements Comparable<Student> {
        int mathScore;
        int engScore;

        public Student(int mathScore, int engScore){
            this.mathScore = mathScore;
            this.engScore = engScore;
        }

        @Override
        public int compareTo(@NotNull Student o) {
            // o1은 나 자신(this), o2는 비교 대상(other)이 됩니다.
            if(this.mathScore == o.mathScore){
                return o.engScore - this.engScore; // 영어 점수 내림차순
            }else{
                return this.mathScore - o.mathScore; // 수학 점수 오름차순
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(1);
        pq.offer(6);
        pq.offer(2);

        while (!pq.isEmpty()){
            System.out.println("pq.poll() = " + pq.poll());
        }

        PriorityQueue<Student> pqC = new PriorityQueue<>(((o1, o2) -> {
            if(o1.mathScore == o2.mathScore){
                return o2.engScore - o1.engScore;
            }else{
                return o1.mathScore - o2.mathScore;
            }
        }));

        while(!pqC.isEmpty()){
            Student s = pqC.poll();
            System.out.printf("Student\'s MathScore and engScore: %d, %d \n", s.mathScore, s.engScore);
        }

        PriorityQueue<MyMember> pqR = new PriorityQueue<>((m1, m2) -> m1.age - m2.age);
    }

}
