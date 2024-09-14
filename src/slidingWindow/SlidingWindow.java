package slidingWindow;

import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    //https://leetcode.com/problems/minimum-window-substring/
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap();
        for(char c : s.toCharArray())
            map.put(c,0);
        for(char c : t.toCharArray())
        {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }

        int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
        while(end < s.length())
        {
            char c1 = s.charAt(end);
            if(map.get(c1) > 0) {
                counter--;
            }
            map.put(c1,map.get(c1)-1);
            end++;

            while(counter == 0)
            {
                if(minLen > end-start) {
                    minLen = end-start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2)+1);

                if(map.get(c2) > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }

    public static String minWindow2(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0; int end = 0; int size = s.length(); int minStart = 0; int minLen = Integer.MAX_VALUE; int counter = t.length();

        while(end < size) {
            if (map[s.charAt(end)] > 0) {
                counter--;
            }
            map[s.charAt(end)]--;
            end++;

            while(counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                map[s.charAt(start)]++;
                if(map[s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
