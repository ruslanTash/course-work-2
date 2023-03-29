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
        System.out.println("3 - удалить задачу по id");
        System.out.println("4 - вывести удалённые задачи");
        System.out.println("5 - вывести задачи на текущий день");
        System.out.println("6 - ввести дату задачи по id");
        System.out.println("7 - редактировать заголовок задачи по id");
        System.out.println("8 - редактировать описание задачи по id");
        System.out.println("9 - вывести задачи на определённую дату");
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
                            } else {
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
                        case 6:
                            System.out.println("Введите номер задачи, в которой нужно изменить дату и через пробел");
                            System.out.println("введите дату, месяц, год");
                            int id, day, month, year;
                            if (scanner.hasNextInt()){
                                id = scanner.nextInt();
                            } else {
                                scanner.next();
                                System.out.println("неверные данные!");
                                continue;
                            }
                            if (scanner.hasNextInt()){
                                day = scanner.nextInt();
                            } else {
                                scanner.next();
                                System.out.println("неверные данные!");
                                continue;
                            }
                            if (scanner.hasNextInt()){
                                month = scanner.nextInt();
                            } else {
                                scanner.next();
                                System.out.println("неверные данные!");
                                continue;
                            }
                            if (scanner.hasNextInt()){
                                year = scanner.nextInt();
                            } else {
                                scanner.next();
                                System.out.println("неверные данные!");
                                continue;
                            }
                            tasks.setDate(id, day, month, year);
                            break;
                        case 7:
                            System.out.println("Введите id задачи через пробел новый заголовок");
                            tasks.setTitle(scanner.nextInt(), scanner.nextLine());
                            break;
                        case 8:
                            System.out.println("Введите id задачи и через пробел новое описание");
                            tasks.setDescription(scanner.nextInt(), scanner.nextLine());
                            break;
                        case 9:
                            System.out.println("Введите дату для формирования задач");
                            System.out.println("Введите через пробел год - месяц - день месяца");
                            LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            tasks.getAllGroupByDate(date);
                            break;
                        default:
                            System.out.println("Выберите пункт меню из списка! (Введите число от 1 до 9)");
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка! (Введите число от 1 до 9)");
                }
            }
        }
    }
}
