import java.util.*;
class StringLengthComparator implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        return s1.length()-s2.length(); // for ascending order based on length
    }
}
class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer i1,Integer i2){
        return i2-i1; // for descending order
    }
}
public class ComparatorStudy {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);    
        list.sort(new MyComparator()); // null means natural order
        System.out.println(list);
        List<String>list2=Arrays.asList("banana","apple","date"); // asList is static method of Arrays class used to create a fixed-size list
         list2.sort(new StringLengthComparator());
         System.out.println(list2);

         // but i want small words come first
         //like date, apple, banana -> based on length of string
         // we will use comparator interface because it has compare method which we can override to provide our own logic and then pass it to sort method


    }
}