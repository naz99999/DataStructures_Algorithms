package LLD;

import java.util.function.BiPredicate;

public class Student {
    public String name;
    public int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isEven = (Integer val1, Integer val2) -> {
            if (val1 + val2 % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
    }
}
