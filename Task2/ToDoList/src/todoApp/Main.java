package todoApp;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			TaskManager taskManager = new TaskManager();
			int taskId = 1;

			while (true) {
			    // Display the interactive menu
			    System.out.println("\nMenu:");
			    System.out.println("1. Add new task");
			    System.out.println("2. Delete task by ID");
			    System.out.println("3. Mark task as completed/incomplete");
			    System.out.println("4. Sort tasks by ascending or descending date");
			    System.out.println("5. View all tasks");
			    System.out.println("6. Exit");
			    System.out.print("Enter your choice: ");
			    
			    // Read user's choice
			    int option = scanner.nextInt();
			    
			    // Perform operations based on the selected option
			    switch (option) {
			        case 1:
			            System.out.print("Enter task name: ");
			            scanner.nextLine(); // Clear the scanner buffer
			            String taskName = scanner.nextLine();
			            System.out.print("Enter task description: ");
			            String taskDescription = scanner.nextLine();
			            System.out.print("Enter task date (YYYY-MM-DD): ");
			            String dateStr = scanner.nextLine();
			            LocalDate date = LocalDate.parse(dateStr);
			            System.out.print("Completed? (true/false): ");
			            boolean completedTask = scanner.nextBoolean();
			            System.out.print("Enter task priority (H/I/L): ");
			            char priorityTask = scanner.next().charAt(0);
			            taskManager.addTask(taskId++, date, taskName, taskDescription, completedTask, priorityTask);
			            System.out.println("Task added successfully.");
			            break;
			        case 2:
			            System.out.print("Enter the ID of the task to delete: ");
			            int idToDelete = scanner.nextInt();
			            if (taskManager.deleteTask(idToDelete)) {
			                System.out.println("Task deleted successfully.");
			            } else {
			                System.out.println("No task found with the specified ID.");
			            }
			            break;
			        case 3:
			            System.out.print("Enter the ID of the task to mark: ");
			            int idToMark = scanner.nextInt();
			            System.out.print("Completed? (true/false): ");
			            boolean completed = scanner.nextBoolean();
			            taskManager.markTask(idToMark, completed);
			            System.out.println("Task marked successfully.");
			            break;
			        case 4:
			            System.out.print("Sort by ascending date? (true/false): ");
			            boolean ascending = scanner.nextBoolean();
			            taskManager.sortTasksByDate(ascending);
			            System.out.println("Tasks sorted successfully.");
			            break;
			        case 5:
			            taskManager.viewTasks();
			            break;
			        case 6:
			            System.out.println("Exiting...");
			            System.exit(0);
			        default:
			            System.out.println("Invalid option. Please enter a valid number.");
			    }
			}
		}
    }
}


