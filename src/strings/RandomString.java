package strings;

import java.util.Random;

public class RandomString {
    public static void main(String args[]) {
        int size = 5;

        //STRING BUFFER IS IMMUTABLE, WILL ONLY MAKE CHANGE TO THE INITIAL OBJECT
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<size; i++) {
            buffer.append(getRandomCharacter());
        }
        System.out.println(buffer);
    }

    private static Character getRandomCharacter() {
        Random random = new Random();
        char ch = (char)(97 + (26 * random.nextFloat()));
        return ch;
    }
}
