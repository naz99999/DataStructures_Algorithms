package ctci;

import java.util.*;


public class ArraysAndStrings {
    public static void main(String args[]) {
        //System.out.println(isUnique("abcdefglkomnh"));
        //checkPermutation("abca", "");
        System.out.println(checkPermutation("abcdef", "acbfde"));
        Character[] charArray = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        System.out.println(Arrays.toString(urlify(charArray, 13)));
    }

    public static boolean isUnique(String string) {

//        boolean[] set = new boolean[128];
//
//        for(char c : string.toCharArray()) {
//            if (set[c - 0]) {
//                return false;
//            } else {
//                set[c - 0] = true;
//            }
//        }
//        return true;

        //Bitset is more memory efficient than boolean[]
        BitSet bitSet = new BitSet(128);
        for(char c : string.toCharArray()) {
            if (bitSet.get(c - 0)) {
                return false;
            } else {
                bitSet.set(c - 0);
            }
        }
        return true;
    }

    public static void checkPermutationOFFTOPIC(String string1, String string2) {
         checkPermutationHelper(string1, "", 0, string2);
    }

    private static void checkPermutationHelper(String unprocessed, String processed, int index, String str2) {
        if (processed.length() == unprocessed.length()) {
            System.out.println("Base case - " + processed);
            return;
        }

        char ch = unprocessed.charAt(index);
        for (int i = 0; i < unprocessed.length(); i++) {
            if (i <= processed.length()) {
                System.out.println(processed + " " + i);
                String newProcessed = processed.substring(0, i) + ch + processed.substring(i);
                checkPermutationHelper(unprocessed, newProcessed, index + 1, str2);
            }
        }
    }

    //TC - O(N logN), SC - O(1)
    public static void checkPermutation2(String string1, String string2) {
        if (sort(string1).equals(sort(string2))) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    private static String sort(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    //TC - O(N), SC - O(1)
    public static boolean checkPermutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[128];

        for (char c : s.toCharArray()) {
            arr[c - '0']++;
        }

        for (char c : t.toCharArray()) {
            arr[c - '0']--;
            if (arr[c - '0'] < 0) return false;
        }
        return true;
    }

    //TC - O(N^2) SC - O(1)
    public static Character[] urlify2(Character[] s, int length) {
        int lastCharIndex = length - 1;
        int i = 0;
        while (i <= lastCharIndex) {
            if (s[i] == ' ') {
                moveIndicesBy1(s, i, lastCharIndex);
                s[i] = '%';
                s [i + 1] = '2';
                s [i + 2] = '0';
                i = i + 3;
                lastCharIndex += 2;
            } else {
                i += 1;
            }
        }
        return s;
    }

    private static void moveIndicesBy1(Character[] s, int currChar, int lastCharIndex) {
        for (int i = lastCharIndex; i > currChar; i--) {
            s[i + 2] = s[i];
        }
    }

    public static char[] urlify(char[] s, int length) {
        int spaces = 0;
        
        for (int i = 0; i < length; i++) {
            if (s[i] == ' ') {
                spaces++;
            }
        }

        int index
    }
}



















