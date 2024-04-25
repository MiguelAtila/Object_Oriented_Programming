package todoApp;

import java.time.LocalDate;

public class Task {
    private int taskId;
    private LocalDate taskDate;
    private String taskName;
    private String taskDescription;
    private boolean taskState;
    private char priority;

    public Task(int taskId, LocalDate taskDate, String taskName, String taskDescription, boolean taskState, char priority) {
        this.taskId = taskId;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskState = taskState;
        this.priority = priority;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskDate=" + taskDate +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskState=" + taskState +
                ", priority=" + priority +
                '}';
    }

    public void setCompleted(boolean completed) {
        // TODO Auto-generated method stub
        
    }
}

