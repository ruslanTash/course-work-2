package Diary;

import java.awt.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;

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

}
