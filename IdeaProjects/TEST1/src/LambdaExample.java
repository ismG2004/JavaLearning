import java.util.function.ToIntBiFunction;

public class LambdaExample {
    public static void processTwoNumbers(int a, int b, ToIntBiFunction<Integer, Integer> function) {
        function.applyAsInt(a, b);
    }

    public static void main(String[] args) {

        ToIntBiFunction<Integer, Integer> myTestFunction1 = (a, b) -> a + b;


        processTwoNumbers(1, 2, (a, b) -> a + b);

    }
}