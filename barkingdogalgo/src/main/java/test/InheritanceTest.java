package test;

public class InheritanceTest {
    // 부모 클래스 A
    static class A {
        String name = "부모 클래스 A";

        public A(String name){
            System.out.println("부모 클래스 호출 " + this.name);
        }

        void greet() {
            System.out.println("안녕하세요, " + name + "입니다.");
        }
    }

    // 자식 클래스 B
    static class B extends A {
        String name = "자식 클래스 B";

        public B(String name) {
            super(name);
            System.out.println("자식 생성자 호출 : " + this.name);
        }

        // 메서드 오버라이딩
        @Override
        void greet() {
            System.out.println("안녕하세요, " + name + "입니다.");
        }

        void childOnlyMethod() {
            System.out.println("자식 클래스에서만 정의된 메서드입니다.");
        }
    }

    public static void main(String[] args) {
        A parent = new A("나는 부모");
        parent.greet(); // 출력: 안녕하세요, 부모 클래스 A입니다.
        System.out.println(parent.name);

        B child = new B("나는 자식");
        child.greet(); // 출력: 안녕하세요, 자식 클래스 B입니다.
        System.out.println(child.name);

        A upcast = new B("나는 업캐스팅 자식");
        upcast.greet();
        System.out.println(upcast.name);
    }
}
