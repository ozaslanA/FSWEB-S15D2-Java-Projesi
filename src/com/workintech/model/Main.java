package com.workintech.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Java Collections", "Write List", "Ann", Priority.LOW, Status.ASSIGNED);
        Task task2 = new Task("Java Collections", "Write Set", "Bob", Priority.LOW, Status.ASSIGNED);
        Task task3 = new Task("Java Collections", "Write LinkedList", "Carol", Priority.LOW, Status.ASSIGNED);
        Task task4 = new Task("Java Collections", "Write ArrayLİst", "Ann", Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collections", "Write Map", "Bob", Priority.LOW, Status.ASSIGNED);
        Task task6 = new Task("Java Collections", "Write List in Set", "", Priority.MED, Status.IN_QUEUE);
        Task task7 = new Task("Java Collections", "Write ArrayLİst", "Bob", Priority.LOW, Status.ASSIGNED);

        Set<Task> totalTasks = new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);
        totalTasks.add(task7);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task1);
        annsTask.add(task4);

        Set<Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(task2);
        bobsTask.add(task5);

        Set<Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(task3);
        carolsTask.add(task7);

        Set<Task> unassignedTask = new HashSet<>();
        unassignedTask.add(task6);

        TaskData taskData = new TaskData(annsTask, bobsTask, carolsTask, unassignedTask);
        // List<Set<Task>> tasks = new ArrayList<>();
        // tasks.add(annsTask);
        // tasks.add(bobsTask);
        // tasks.add(carolsTask);
        // System.out.println(taskData.getUnion(tasks));

        // Get all tasks
        System.out.println("All tasks: ");
        System.out.println(taskData.getTasks("all"));

        System.out.println("Ann's Task: ");
        System.out.println(taskData.getTasks("Ann"));

        System.out.println("Bob's Task: ");
        System.out.println(taskData.getTasks("Bob"));

        System.out.println("Carol's Task: ");
        System.out.println(taskData.getTasks("Carol"));

        // Unassigned Tasks
        System.out.println(taskData.getDifference(totalTasks, taskData.getTasks("all")));

        // Assigned to multiple assignees
        System.out.println("Ann + Carol: " + taskData.getIntersection(annsTask, carolsTask));
        System.out.println("Bob + Carol: " + taskData.getIntersection( carolsTask,bobsTask));
        System.out.println("Ann + Bob: " + taskData.getIntersection(annsTask, bobsTask));
    }
}
