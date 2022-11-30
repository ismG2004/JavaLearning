import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;
public class NewExample {
    static Integer addList(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        // Creating a list and adding values  
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        // Referring addList() method  
//        Function<List<Integer>, Integer> function = NewExample::addList;
        Function<List<Integer>, Integer> function = (list1)
                -> list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        // Calling Function interface method  
        int result = function.apply(list);
        System.out.println("Sum of list values: "+result);
    }
}