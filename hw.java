package hw3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hw {

    public static String[] userData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел:\n" +
                "Фамилия Имя Отчество\n" +
                "дата рождения(dd.mm.yyyy)\n" +
                "номер телефона(без дополнительных знакоВ)\n" +
                "пол(f or m)");
        String[] data = scanner.nextLine().split(" ");
        if (lengthCheck(data)) {
            System.out.println(lengthCheck(data));
            throw new MyArrayLengthCheckException();
        }
        return data;
    }

    public static boolean lengthCheck(String[] arr) {
        if (arr.length != 6) {
            return true;
        }
        return false;
    }

    public static boolean checkData(String[] userData) {
        if (nameCheck(userData) && checkDateBirth(userData) && phoneNumber(userData) && genderCheck(userData)) {
            return true;
        }
        return false;

    }

    public static boolean nameCheck(String[] userData) {
        String surName = userData[0];
        String name = userData[1];
        String patronymic = userData[2];
        boolean rezult = false;
        if (stringCheck(surName) && stringCheck(name) && stringCheck(patronymic)) {
            rezult = true;
        } else {
            rezult = false;
            throw new MyCheckStringNameException();
        }
        return rezult;

    }

    public static boolean stringCheck(String name) {
        if (name != null && name.matches("^[a-zA-Z]*$")) {
            return true;
        } else
            return false;
    }

    public static boolean checkNums(String s, int length) {
        if (s.matches("^[0-9]*$") && s.length() == length) {
            return true;
        }
        return false;
    }

    public static boolean checkDateBirth(String[] userData) {

        String[] data = userData[3].split("\\.");
        int num = data.length;
        if ((num == 3) && checkNums(data[0], 2) && checkNums(data[1], 2) && checkNums(data[2], 4)) {
            return true;
        }
        System.out.println("Неверный ввод даты рождения! ");
        return false;
    }

    public static boolean phoneNumber(String[] userData) {
        if (userData[4].matches("^[0-9]*$")) {
            return true;
        }
        System.out.println("Ошибка В телефоне! Можно вводить только цифры!");
        return false;

    }

    public static boolean genderCheck(String[] userData) {
        if (userData[5].toLowerCase().equals("m") || userData[5].toLowerCase().equals("f")) {
            return true;
        }
        System.out.println("Неверно введен пол!");
        return false;
    }

    public static void write(String text, String path) throws IOException {
        try (FileWriter writer = new FileWriter(new File(path), true)) {
            writer.write(text);
            writer.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        String[] userData = userData();
        String surname = userData[0];
        String name = userData[1];
        String patronymic = userData[2];
        String burthDate = userData[3];
        String phoneNumber = userData[4];
        String gender = userData[5];
        Human human = new Human(surname, name, patronymic, burthDate, phoneNumber, gender);
        String text = human.toString();
        if (checkData(userData)) {
            String path = surname + ".txt";
            write(text, path);
        }

    }
}
