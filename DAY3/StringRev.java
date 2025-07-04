
public class StringRev {

    static String reverse(String str) {
        if (str.length() == 0) {
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);

    }

    public static void main(String[] args) {
        String input = "Hello";
        String rev = reverse(input);
        System.out.println("The original string is: " + input + "\nThe reversed string is: " + rev);
    }
}

