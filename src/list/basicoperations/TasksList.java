package list.basicoperations;

import java.util.ArrayList;
import java.util.List;

public class TasksList {

    private List<Task> taskList;

    public TasksList() {
        this.taskList = new ArrayList<>();
    }


    public void addTask(String description) {
        taskList.add(new Task(description));
    }

    public void removeTask(String description) {
        List<Task> taskForRemove = new ArrayList<>();
        if (!taskList.isEmpty()) {
            for (Task t : taskList) {
                if (t.getDescription().equalsIgnoreCase(description)) {
                    taskForRemove.add(t);
                }
            }
            taskList.removeAll(taskForRemove);
        } else {
            System.out.println("The task list is empty");
        }
    }


    public int getTotalNumberTasks() {
        return taskList.size();
    }

    public void getDescriptionTasks() {
        System.out.println(taskList);
    }

    public static void main(String[] args) {
        TasksList tasksList = new TasksList();
        System.out.println("O numero do total de elementos e " + tasksList.getTotalNumberTasks());

        tasksList.addTask("Tarefa 01");
        tasksList.addTask("Tarefa 01");
        tasksList.addTask("Tarefa 03");
        System.out.println("O numero do total de elementos e " + tasksList.getTotalNumberTasks());

        tasksList.removeTask("Tarefa 01");
        System.out.println("O numero do total de elementos e " + tasksList.getTotalNumberTasks());

        tasksList.getDescriptionTasks();
    }
}
