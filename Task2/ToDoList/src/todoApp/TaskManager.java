package todoApp;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class TaskManager {
    private Map<Integer, Task> tasks;

    public TaskManager() {
        tasks = new HashMap<Integer, Task>();
    }

    public void addTask(int taskId, LocalDate date, String name, String description, boolean completed, char priority) {
        Task newTask = new Task(taskId, date, name, description, completed, priority);
        tasks.put(taskId, newTask);
    }

    public boolean deleteTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return true;
        }
        return false;
    }

    public void markTask(int taskId, boolean completed) {
        if (tasks.containsKey(taskId)) {
            Task task = tasks.get(taskId);
            task.setCompleted(completed);
        } else {
            System.out.println("No task found with the specified ID.");
        }
    }

    public void sortTasksByDate(boolean ascending) {
        // out of service jaja
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned.");
        } else {
            System.out.println("List of assigned tasks:");
            for (Task task : tasks.values()) {
                System.out.println(task);
            }
        }
    }
}


