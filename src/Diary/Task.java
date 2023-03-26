package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

import static java.time.LocalDateTime.now;

public class Task {
    private static int idGeneration = 0;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;
    private Repeatability repeatability;

    public Task(String title, int a, int b, String description) {
        idGeneration++;
        this.id = idGeneration;
        this.title = title;
        this.type = Type.getType(a);
        this.description = description;
        this.dateTime = now();
        this.repeatability = Repeatability.getRepeatability(b);
    }


    public int getIdGeneration() {
        return idGeneration;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return title.equals(task.title) && type == task.type && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, description);
    }

    @Override
    public String toString() {
        return "{" +
                "Задача: '" + title + '\'' +
                "; тип: " + type +
                "; дата: " + dateTime.getDayOfMonth() + "-" + dateTime.getMonth() + "-" + dateTime.getYear() +
                "; описание: '" + description + '\'' +
                "; повторяемость: " + repeatability +
                "}\n";
    }

}
