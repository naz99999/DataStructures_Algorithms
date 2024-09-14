package numbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LargeNumbers {
    public static void main(String args[]) {
        BigInteger a = BigInteger.valueOf(95);
        BigInteger b = BigInteger.valueOf(2);
        //int y = 391835429675039530965652;
        BigInteger c = new BigInteger("391835429675039530965652");

        BigInteger constant = BigInteger.TEN;
        System.out.println(a + " " + b + " " + c);

        int num = 1343;

        System.out.println(fact(num));

        BigDecimal d1 = BigDecimal.valueOf(4645243537453455376464.132542298472072482462845924720574284274274098859765464522424224);
        BigDecimal d2 = BigDecimal.valueOf(464534242322476464.1323242342524);
        BigDecimal d3 = new BigDecimal("312313144523897498759479285749826597498543.424624224287498");
        BigDecimal d4 = new BigDecimal("342312313144523897445453453498759479285749826597498543.4246287498");
        System.out.println(d1.multiply(d2));
        System.out.println(d3.multiply(d4));

        double x = 0.02;
        double y = 0.03;
        System.out.println(x-y); //10 ^-19 error

        BigDecimal x1 = BigDecimal.valueOf(0.02);
        BigDecimal x2 = BigDecimal.valueOf(0.03);
        System.out.println(x1.subtract(x2));

    }

    private static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");
        for (int i=2; i<num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

}
