package Diary;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.LocalDateTime.now;

public class Task {
    private static int idGeneration = 0;
    private String title;
    private Type type;
    private int id;
    private LocalDate dateTime;
    private String description;
    private Repeatability repeatability;

    public Task(String title, int type, int repeat, String description) {
        idGeneration++;
        this.id = idGeneration;
        this.title = title;
        this.type = Type.getType(type);
        this.description = description;
        this.dateTime = LocalDate.now();
        this.repeatability = Repeatability.getRepeatability(repeat);
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDate(int day, int month, int year) {
        this.dateTime = LocalDate.of(year, month, day);
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

    boolean appearsIn(LocalDate localDate) {
        if (this.repeatability == Repeatability.DIALY){
            return true;
        } else if (this.repeatability == Repeatability.WEEKLY) {
            return getDateTime().getDayOfWeek() == localDate.getDayOfWeek();
        } else if (this.repeatability == Repeatability.MONTLY) {
            return getDateTime().getDayOfMonth() == localDate.getDayOfMonth();
        } else if (this.repeatability == Repeatability.YEARLY) {
            return getDateTime().getDayOfYear() == localDate.getDayOfYear();
        } else {
            return false;
        }
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
