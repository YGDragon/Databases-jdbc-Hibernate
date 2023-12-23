package services;

import models.Course;

import java.util.Locale;
import java.util.Scanner;

public class AppView {
    public void exitMessage() {
        System.out.println("Приложение остановлено!");
    }

    public void viewMenu() {
        String[] menuItems = {
                "Выход",
                "Добавить",
                "Получить по ID",
                "Обновить по ID",
                "Получить всё",
                "Удалить по ID",
                "Удалить всё"
        };
        System.out.println("\nменю: ".toUpperCase(Locale.ROOT));
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i] + " ___ введи " + i);
        }
    }

    public Long inputID() {
        System.out.print("Введи ID записи >>> ");
        return Long.parseLong(new Scanner(System.in).nextLine());
    }

    public String inputItem() {
        System.out.print("Введи номер пункта меню >>> ");
        return new Scanner(System.in).nextLine();
    }

    public void writeMessage() {
        System.out.println("Добавлена новая запись");
    }

    public void addMessage(Course course) {
        System.out.println("Данные прочитаны >>> " + course);
    }

    public void emptyMessage() {
        System.out.println("Данные отсутствуют!");
    }
}