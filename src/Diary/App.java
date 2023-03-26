package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

import static Diary.TaskService.getRemovedTasks;

public class App {

    public static void printMenu() {
        System.out.println("1 - вывести список задач");
        System.out.println("2 - добавить задачу");
        System.out.println("3 - удалить задачу");
        System.out.println("4 - вывести удалённые задачи");
        System.out.println("5 - вывести задачи на день");
    }





    public static void main(String[] args) {
        TaskService tasks = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Выберите пункт меню:");
                printMenu();
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            System.out.println(tasks);
                            break;
                        case 2:
                            System.out.println("Заполните параметры задачи через пробел:" +
                                    "\nЗаголовок (без пробелов)" +
                                    "\nТип (1 - рабочая, 2 - личная)" +
                                    "\nПовторяемость" +
                                    "(1 - Еженедельная, 2 - Ежемесячная, 3 - Ежедневная, 4 - Ежегодная, 0 - Однакратная)" +
                                    "\nОписание (тескт)");
                            tasks.add(new Task(
                                    scanner.next(),
                                    scanner.nextInt(),
                                    scanner.nextInt(),
                                    scanner.nextLine()));
                            break;
                        case 3:
                            System.out.println("Удалить задачу - введите номер задачи:");
                            if (scanner.hasNextInt()) {
                                tasks.remove(scanner.nextInt());
                                break;
                            }else {
                                scanner.next();
                                System.out.println("Неверное значение, нужно вводить номер id задачи!!!");
                                continue;
                            }
                        case 4:
                            System.out.println("Удалённые задачи:");
                            getRemovedTasks();
                            break;
                        case 5:
                            System.out.println("Вывести задачи на день:");
                        tasks.getAllByDate();
                            break;
                    }
                }else{
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка! (Введите число от 1 до 6)");
                }
            }
        }
    }
}
