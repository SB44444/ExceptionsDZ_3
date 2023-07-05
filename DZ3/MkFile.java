package DZ3.ExcepDZ3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MkFile {
    public static void mkFile(String userData, String fileName) {
        if (Files.exists(Path.of(fileName + ".txt"))) {
            String inputData = readFile(fileName);
            if (!inputData.contains(userData)) {
                writerFile(fileName, userData, true);
                System.out.println("Запись данных выполнена");
            } else System.out.println("Введенные данные были записаны ранее");
        } else {
            writerFile(fileName, userData, false);
            System.out.println("Файл " + fileName + ".txt создан");
        }
    }

    public static String readFile(String fileName) {
        String result;
        try (FileReader reader = new FileReader(fileName + ".txt")) {
            StringBuilder str = new StringBuilder();
            int el;
            while ((el = reader.read()) != -1) {
                str.append((char) el);
            }
            result = str.toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла " + e);
        }
        return result;
    }

    public static void writerFile(String writingName, String text, boolean symbol) {
        try (FileWriter writer = new FileWriter(writingName + ".txt", symbol)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи файла" + e);
        }
    }
}