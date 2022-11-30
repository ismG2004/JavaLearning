public class Example {
    public static void main(String[] args) {
        String originalString = "Hello Ismayil";
        String reversedString = "";

        for (int i = 0; i < originalString.length(); i++) {
            reversedString = originalString.charAt(i) + reversedString;
        }

        System.out.println(reversedString);
    }
}