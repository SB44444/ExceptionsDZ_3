package DZ3.ExcepDZ3;

import java.util.Scanner;

public class UserData {
    public static void listData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные пользователя в следующем формате:\nФамилия пробел Имя пробел Отчество пробел Дата рождения пробел Телефон пробел пол");
        System.out.println("Пример:\nИванов Иван Иванович 10.01.2001 8928415432 m");
        System.out.println("Фамилия Имя Отчество через пробел\nДата рождения цифрами, в формате dd.MM.yyyy");
        System.out.println("Номер телефона цифрами, в формате 8000000000\nПол латинскими буквами f или m");
        System.out.println("Подтвердите ввод клавишей ENTER\nДля выхода введите Q и подтвердите ввод клавишей ENTER");

        while (true) {
            String[] inArr = in.nextLine().split(" ");
            if (inArr[0].equalsIgnoreCase("Q")) {
                in.close();
                System.out.println("Работа программы завершена");
                break;
            }
            ExcepProc.dataArr(inArr);
        }
    }
}