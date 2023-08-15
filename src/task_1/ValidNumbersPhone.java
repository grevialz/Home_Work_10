package task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumbersPhone {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Home_Work_10\\src\\task_1\\file.txt"))) {
            String str;
            Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
            while ((str = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches()) {
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}