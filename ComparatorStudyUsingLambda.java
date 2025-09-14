import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
class student implements Comparable<student>{
    String name;
    double gpa;
    student(String name,double gpa){
        this.name=name;
        this.gpa=gpa;
    }
    public String getName(){
        return name;
    }   
    public double getGpa(){
        return gpa;
    }

    @Override
    public int compareTo(student o) {
        return Double.compare(this.gpa, o.gpa); // ascending order based on gpa

    }
    @Override
    public String toString(){
        return this.name+" "+this.gpa;
    }
}
public class ComparatorStudyUsingLambda {

    public static void main(String[] args) {
       List<String>list=Arrays.asList("banana","apple","date"); // asList is static method of Arrays class used to create a fixed-size list

        list.sort((a,b)->a.length()-b.length()); // lambda expression
        System.out.println(list);

        List<Integer> list2 = Arrays.asList(1, 3, 2);
        list2.sort((a, b) -> a - b); // lambda expression
        System.out.println(list2);
    List<student> students = Arrays.asList(
        new student("Alice", 3.5),
        new student("Bob", 3.8),
        new student("Charlie", 3.2),
        new student("David", 3.8)
    );

    Comparator<student>comparator=Comparator.comparing(student::getGpa).thenComparing(student::getName); //method reference and thenComparing for secondary sorting 
    students.sort(comparator);

    // students.sort((a,b)->{
    //     if((a.getGpa()-b.getGpa())>0){
    //         return 1;
    //     }
    //     else if((a.getGpa()-b.getGpa())<0){
    //         return -1;
    //     }
    //     else return 0;
    // }); // custom sorting logic
    for(student s:students){
        System.out.println(s.getName()+" "+s.getGpa());
    }
}
}