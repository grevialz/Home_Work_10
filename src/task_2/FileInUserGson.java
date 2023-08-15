package task_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInUserGson {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("D:\\Home_Work_10\\src\\task_2\\file.txt"))) {
            String[] headers = scanner.nextLine().split(" ");
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(" ");
                String name = values[0];
                int age = Integer.parseInt(values[1]);
                userList.add(new User(name, age));
            }
        } catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s%n", e);
        }

        try (Writer writer = new FileWriter("user.json")) {
            writer.write("[\n");
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                writer.write("    {\n");
                writer.write("        \"name\": \"" + user.getName() + "\",\n");
                writer.write("        \"age\": " + user.getAge() + "\n");
                writer.write("    }");
                if (i < userList.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}