public class Test2 {
    public static void main(String args[]) {
        System.out.println(Integer.MAX_VALUE);
        String num1 = "2147483648";
        long n1 = 2147483648l;
        System.out.println((int)n1);
        System.out.println(Integer.parseInt(num1));

    }

    /*
0 1 2 3
0 0 1 2
------
0 2 4 6
1 2 3 X
-------
1 4 7 6
     */

    public static void multiply(String n1, String n2) {

        String product = multiplyStrings(n1, n2);

        int maxWidth = Math.max(n1.length(), Math.max(n2.length(), (product).length()));

        System.out.println(formatWithLeadingZeroes(n1, maxWidth));
        System.out.println(formatWithLeadingZeroes(n2, maxWidth));

//        System.out

    }

    private static String multiplyStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        int[] result = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j>=0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(i) - '0';

                int product = digit1 * digit2 + result[i + j + 1];
                result[i + j + 1] = product % 10; //single digit
                //999
                //999   [0,0,0,0,0,0]
                //      [0,0,0,8,9,1]
                result[i + j] += product/10; //carry over
            }
        }

        StringBuilder productStr = new StringBuilder();
        for (int num : result) {
            if (!(productStr.length() == 0)) {
                productStr.append(num);
            }
        }
        return productStr.length() == 0 ? "0" : productStr.toString();
    }

    private static String formatWithLeadingZeroes(String num, int width) {
        return String.format("%" + width + "s", num).replace(' ', '0');
    }
}























