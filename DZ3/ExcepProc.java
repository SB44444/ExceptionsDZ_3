package DZ3.ExcepDZ3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExcepProc {
    public static void dataArr(String[] userData) {
        int counter = 0;
        if (userData.length != 6) {System.out.println("Ошибка формата ввода по количеству данных: повторите ввод");
            counter++;
        } else {
            if (!userData[0].matches("[а-яА-Яa-zA-Z]+")) {System.out.println("Ошибка ввода фамилии: повторите ввод");
                counter++;
            }
            if (!userData[1].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Ошибка ввода имени, повторите ввод");
                counter++;
            }
            if (!userData[2].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Ошибка ввода отчества, повторите ввод");
                counter++;
            }
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            try {
                df.parse(userData[3]);
            } catch (ParseException e) {System.out.println("Ошибка ввода формата даты, повторите ввод");
                counter++;
            }
            try {
                Long.parseLong(userData[4]);
            } catch (NumberFormatException e) {System.out.println("Ошибка ввода формата номера телефона, повторите ввод");
                counter++;
            }
            if (!userData[5].equalsIgnoreCase("m") && !userData[5].equalsIgnoreCase("f")) {
                System.out.println("Ошибка ввода навания пола, повторите ввод");
                counter++;
            }
        }
        if (counter == 0) {
            StringBuilder userStr = new StringBuilder();
            for (int i = 0; i < userData.length; i++) {
                if (i == userData.length - 1) {
                    userStr.append(userData[i]);
                } else {
                    userStr.append(userData[i]).append(" ");

                }
            }
            MkFile.mkFile(userStr.toString(), userData[0]);
        }
    }
}