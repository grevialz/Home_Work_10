package task_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FrequencyOfEachWord {
    public static void main(String[] args) {
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = countWordFrequency("src/task_3/words.txt");
        while (!priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            String word = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(word + " " + frequency);
        }
    }

    public static PriorityQueue<Map.Entry<String, Integer>> countWordFrequency(String filePath) {
        Map<String, Integer> map = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String word = scanner.next();

                word = word.replaceAll("[\\n\\r.,;:!?(){}\\[\\]]", "");

                if (!word.isEmpty()) {
                    int count = map.getOrDefault(word, 0);
                    map.put(word, count + 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PriorityQueue<Map.Entry<String, Integer>> wordFrequency = new PriorityQueue<>(
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordFrequency.add(Map.entry(entry.getKey(), entry.getValue()));
        }
        return wordFrequency;
    }
}