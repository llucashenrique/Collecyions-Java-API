package set.search;

import java.util.HashSet;
import java.util.Set;

public class ListTaks {

    private Set<Task> taskSet;

    public ListTaks() {
        this.taskSet = new HashSet<>();
    }

    public void addTask(String description) {
        taskSet.add(new Task(description));
    }

    public void removeTask(String description) {
        Task taskByRemove = null;
        if (!taskSet.isEmpty()) {
            for (Task task : taskSet) {
                if (task.getDescription().equalsIgnoreCase(description)) {
                    taskByRemove = task;
                    break;
                }
            }
            taskSet.remove(taskByRemove);
        } else {
            System.out.println("The task list is empty");
        }

        if (taskByRemove == null) {
            System.out.println("The task not found!");
        }
    }

    public void displayTask() {
        if (!taskSet.isEmpty()) {
            System.out.println(taskSet);
        } else {
            System.out.println("Task can't be found");
        }
    }

    public int countTask() {
        return taskSet.size();
    }

    public Set<Task> getTaskSetComplete() {
        Set<Task> tasksCompleted = new HashSet<>();
        for (Task t : taskSet) {
            if (t.isCompleted()) {
                tasksCompleted.add(t);
            }
        }
        return tasksCompleted;
    }

    public Set<Task> getTaskSetPending() {
        Set<Task> taskNotComplete = new HashSet<>();
        for (Task t : taskSet) {
            if (t.isCompleted()) {
                taskNotComplete.add(t);
            }
        }
        return taskNotComplete;
    }


    public void markTaskCompleted(String description) {
        for (Task task : taskSet) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.setCompleted(true);
            }
        }
    }

    public void markTaskPending(String description) {
        Task taskForMarkPending = null;
        for (Task task : taskSet) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskForMarkPending = task;
                break;
            }
        }

        if (taskForMarkPending != null) {
            if (taskForMarkPending.isCompleted()) {
                taskForMarkPending.setCompleted(false);
            }
        }else {
            System.out.println("Task for mark pending not found");
        }
    }

    public void cleanListTasks(){
        if (taskSet.isEmpty()) {
            System.out.println("The list already empty");
        } else {
            taskSet.clear();
        }
    }

    public static void main(String[] args) {
        ListTaks listTaks = new ListTaks();

        listTaks.addTask("Clean the house");
        listTaks.addTask("To do homework");
        listTaks.addTask("Clean the car");
        listTaks.addTask("Make lunch");
        listTaks.addTask("Learning English");

        System.out.println("Showing all tasks: ");
        listTaks.displayTask();
        System.out.println("------------------------");

        System.out.println("Removing task from list: ");
        listTaks.removeTask("Clean the car");
        listTaks.displayTask();
        System.out.println("---------------------------");

        System.out.println("Counting tasks of the list: ");
        System.out.println("Total tasks on the list");
        System.out.println(listTaks.countTask());
        System.out.println("-------------------------");

        System.out.println("Marking a task to complete: ");
        listTaks.markTaskCompleted("Clean the house");
        listTaks.markTaskCompleted("To do homework");
        listTaks.displayTask();
        System.out.println("---------------------------------");

        System.out.println("Showing tasks that have been completed");
        System.out.println(listTaks.getTaskSetComplete());
        System.out.println("-------------------------------");

        System.out.println("Marking a task to incomplete: ");
        listTaks.markTaskPending("Learning English");
        listTaks.markTaskPending("Make lunch");
        System.out.println("----------------------------");

        System.out.println("Showing tasks that have been incomplete: ");
        System.out.println(listTaks.getTaskSetPending());
        System.out.println("----------------------------");


        System.out.println("Cleaning the list: ");
        listTaks.cleanListTasks();

        listTaks.displayTask();

    }
}
