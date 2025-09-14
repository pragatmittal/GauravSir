import java.util.*;

public class ComparableStudy {
        public static void main(String[] args) {
            List<student> list = new ArrayList<>();
            list.add(new student("Alice", 3.5));
            list.add(new student("Bob", 3.8));
            list.add(new student("Charlie", 3.2));
            list.add(new student("David", 3.8));
            list.sort(null );
            System.out.println(list);
        }
}
