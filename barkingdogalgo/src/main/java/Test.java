import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test{
    public static void main(String[] args) {
        List<Integer> h = new ArrayList<>();
        h.add(2);
        System.out.println(h);
        h.add(1);
        System.out.println(h);
        h.add(1);
        System.out.println(h);
        h.remove(1);
        System.out.println(h);
        System.out.println(h.size());

    }
}