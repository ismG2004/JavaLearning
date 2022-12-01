public class ReverseStringExample {
    public static void main(String[] args) {
//        String string1 = "Salam Murad Necesen?";
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = string1.length() - 1; i >= 0; i--) {
//            stringBuilder.append(string1.charAt(i));
//        }
//        System.out.println(stringBuilder);


        String string1 = "Salam Murad Necesen?";
        char[] chars = string1.toCharArray();
        char[] reversed = new char[string1.length()];

        for (int i = string1.length() - 1; i >= 0; i--) {
            reversed[i] = chars[string1.length() - 1 - i];
        }

        System.out.println(reversed);
    }
}