package Companies.goldman;

import java.util.*;

public class StudentMaximumAverage {
    public static void main(String[] args) {
        // Creating sample data - each inner ArrayList contains [name, marks]
        List<List<String>> studentMarks = new ArrayList<>();

        // Adding dummy data
        studentMarks.add(Arrays.asList("John", "85"));
        studentMarks.add(Arrays.asList("John", "92"));
        studentMarks.add(Arrays.asList("John", "78"));
        studentMarks.add(Arrays.asList("Emma", "95"));
        studentMarks.add(Arrays.asList("Emma", "88"));
        studentMarks.add(Arrays.asList("Emma", "88"));
        studentMarks.add(Arrays.asList("Alex", "76"));
        studentMarks.add(Arrays.asList("Alex", "82"));
        studentMarks.add(Arrays.asList("Alex", "89"));

        double maxAverage = findMaxAverage(studentMarks);
        System.out.println("Maximum average scored by any student: " + maxAverage);
    }

    public static double findMaxAverage(List<List<String>> studentMarks) {
        // TODO: Implement this method to find the maximum average
        // 1. Group marks by student name
        // 2. Calculate average for each student
        // 3. Return the maximum average

        HashMap<String, List<Integer>> map = new HashMap<>();

        for (List<String> entry : studentMarks) {
            String name = entry.get(0);
            Integer marks = Integer.parseInt(entry.get(1));
            map.put(name, map.getOrDefault(name, Arrays.asList(0, 0)));

            List<Integer> marksAndCount = map.get(name);
            int newMarks = marksAndCount.get(0) + marks;
            int newCount = marksAndCount.get(1) + 1;
            marksAndCount.set(0, newMarks);
            marksAndCount.set(1, newCount);
        }

        double maxAvg = 0.0;
        for (List<Integer> marks : map.values()) {
            double avg = (double) marks.get(0) / marks.get(1);
            maxAvg = Math.max(avg, maxAvg);
        }

        return maxAvg; // placeholder return
    }
}