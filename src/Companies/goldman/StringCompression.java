package Companies.goldman;

public class StringCompression {
    public static String compressString(String input) {
        // Your implementation here
        // Goal: Compress the string to the format A B * C * D
        // Where repeated patterns are replaced with *
        return "";
    }

    public static void main(String[] args) {
        String input = " A B A B C A B A B C D";
        String compressed = compressString(input);
        System.out.println("Original: " + input);
        System.out.println("Compressed: " + compressed);
    }
}
