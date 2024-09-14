import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main(String[] args) throws ParseException {

        String input = "11/18/2023";


        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = dateFormat.parse(input);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(myDate);
        cal1.add(Calendar.DAY_OF_YEAR, -1);
        Date newDate = cal1.getTime();


        String todayAsString = dateFormat.format(newDate);


        System.out.println(todayAsString);

        System.out.println(2/10);
        System.out.println(25/10);

        double factor = 1e5; // = 1 * 10^5 = 100000

        double avg = 34;
        //avg = Math.round((avg/4) * factor) / factor;
        System.out.println(avg);
        BigDecimal avgValue = new BigDecimal(avg/4).setScale(5, BigDecimal.ROUND_HALF_UP);
        System.out.println(avgValue.toBigInteger().doubleValue());

        List<Integer> ans = new ArrayList<>();
        helper(ans, 6);
        System.out.println(ans);

        int[] arr = {4};
        int[] arr2 = Arrays.copyOfRange(arr, 1, 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        String ans2 = "";

        List<String> a = new ArrayList<>();
        a.add("-1");a.add("15");a.add("4");
        System.out.println(a.toString());
        String val = String.join(",", a);
        System.out.println(val);

        List<String> b = new ArrayList<>();
        a.add("495");a.add("490");a.add("40");
        System.out.println(Integer.parseInt(a.removeLast()) + Integer.parseInt(a.removeLast()) + Integer.parseInt(a.removeLast()));

        Integer sum = 0;
        //increaseSum(sum);
        increaseSum(sum, b);
        System.out.println(b.size());

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        map.put(0, new ArrayList<>(List.of(3)));
        map.put(0, new ArrayList<>(List.of(4)));
        List<Integer> list = map.get(0);
        list.add(5);
        map.put(0, list );
        System.out.println(map);

        String str = "67eba";
        StringBuilder s = new StringBuilder(str);
        s.setCharAt(1, ' ');
        s.setCharAt(3, ' ');
        System.out.println(s.toString().trim());

    }

    private static void increaseSum(Integer sum, List<String> b) {
        b.add("a");
    }

    private static void helper(List<Integer> ans, int k) {
        if (k == 0) {
            return;
        }
        ans.add(k);
        helper(ans, k - 1);
    }
}
