package soma;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

// 정렬 연습
public class SM_Sort {

    static class Person {
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return this.name;
        }

        public int getAge(){
            return this.age;
        }
    }

    public static void main(String[] args) {
        int[] intArr = {8,7,6,5,4};
        String[] strArr = {"d", "c", "b", "a"};

        Arrays.sort(intArr); // 숫자 오름차순
        Arrays.sort(intArr, 2, 5); // 2~4번 인덱스 까지만 정렬

        // primitive 타입이 아닌 Wrapper 클래스 일 경우 arr 뒤에 추가로 Comparator 를 인자로 전달하여 정렬 가능
        Arrays.sort(strArr, Collections.reverseOrder());

        Integer[] intArrWrapper = new Integer[]{1,3,2,5,4};
        Arrays.sort(intArrWrapper, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);// o1가 o2보다 작으면 양수, o1가 o2보다 크다면 음수(오름차순)
            }
        });

        Integer[] intArrWrapper2 = new Integer[]{1,3,2,5,4};
        Arrays.sort(intArrWrapper2, (a,b) -> a - b); // 오름차순 정렬

        List numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);

        Collections.sort(numbers); // 오름차순 정렬

        ArrayList list = new ArrayList<>();
        list.add("d");
        list.add("e");
        list.add("a");

        Collections.sort(list, Collections.reverseOrder()); // 내림차순
        list.forEach(x-> System.out.println(x));

        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 20));
        Collections.sort(people, (p1, p2) -> p2.getName().compareTo(p1.getName()));
    }
}
