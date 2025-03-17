package strings;

public class StringQuestions {
    public static void main(String args[]) {
        String input="aaaabbbbbbcccdddddaaa";
        System.out.println(getSimplifiedString(input));
    }

    private static String getSimplifiedString(String input) {
        char c = input.charAt(0);
        int count = 1;
        String ans = "";
        for(int i=1; i<input.length(); i++) {
            if (input.charAt(i) == c) {
                count++;
            } else {
                ans += c + String.valueOf(count);
                c = input.charAt(i);
                count = 1;
            }
        }
        ans += c + String.valueOf(count);
        return ans;
    }
}
