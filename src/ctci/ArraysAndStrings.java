package ctci;

import arrays.ArrayQuestions;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ArraysAndStrings {
    public static void main(String args[]) {
        //System.out.println(isUnique("abcdefglkomnh"));
        checkPermutation("abca", "");
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

    public static void checkPermutation(String string1, String string2) {
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
}



















