import java.util.function.ToIntBiFunction;

public class FuncIntExample {
    public static void processTwoNumbers(int a, int b, ToIntBiFunction<Integer, Integer> function) {
        function.applyAsInt(a, b);
    }

    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
//        Function<String, String> nameMappingFunction = String::toUpperCase;
//        List<String> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
//        System.out.println(nameLength);

//        ToIntBiFunction<Integer, Integer> myTestFunction1 = new ToIntBiFunction<>() {
//            @Override
//            public int applyAsInt(Integer a, Integer b) {
//                return a + b;
//            }
//        };

        ToIntBiFunction<Integer, Integer> myTestFunction1 = new ToIntBiFunction<>() {
            @Override
            public int applyAsInt(Integer a, Integer b) {
                return a + b;
            }
        };
//        Classic cl = new Classic();
        processTwoNumbers(10, 2, myTestFunction1);

    }
}