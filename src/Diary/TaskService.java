package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.getInstance;

public class TaskService {
    private Map<Integer, Task> taskMap;
    private static Collection<Task> removedTasks;

    public TaskService() {
        this.taskMap = new TreeMap<>();
        this.removedTasks = new ArrayList<>();
    }

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void remove(int id) {
        removedTasks.add(taskMap.get(id));
        taskMap.remove(id);
    }

    @Override
    public String toString() {
        return "[" + taskMap + "]\n";
    }

    public static void getRemovedTasks() {
        System.out.println("Removed Tasks:\n" + removedTasks);
    }

    public void getAllByDate() {
        Collection<Task> collect = this.taskMap.values()
                .stream()
                .filter(p -> p.getDateTime().getMonthValue() == LocalDateTime.now().getMonthValue()
                        && p.getDateTime().getYear() == (LocalDateTime.now().getYear())
                        && p.getDateTime().getDayOfMonth() == (LocalDateTime.now().getDayOfMonth())
                )
                .collect(Collectors.toCollection(ArrayList<Task>::new));
        System.out.println(collect);
    }

    public void getAllGroupByDate(LocalDate date){
        Collection<Task> list = this.taskMap.values()
                .stream()
                .filter(p -> p.appearsIn(date))
                .collect(Collectors.toCollection(ArrayList<Task>::new));
        System.out.println(list);
    }

    public void setDate(int id, int day, int month, int year) {
        this.taskMap.get(id).setDate(day, month, year);
    }

    public void setTitle(int id, String title) {
        this.taskMap.get(id).setTitle(title);
    }

    public void setDescription(int id, String description) {
        this.taskMap.get(id).setDescription(description);
    }


}
